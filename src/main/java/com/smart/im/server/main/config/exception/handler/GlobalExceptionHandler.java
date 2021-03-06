package com.smart.im.server.main.config.exception.handler;


import com.smart.im.server.main.Constants;
import com.smart.im.server.main.entity.DataResult;
import com.smart.im.server.main.entity.ErrorLog;
import com.smart.im.server.main.eums.ExceptionStatusEnum;
import com.smart.im.server.main.utils.SpringContextHolder;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import static com.smart.im.server.main.Constants.LOG_ERROR;
import static com.smart.im.server.main.utils.IpUtil.getIpAddr;

/**
 * 全局异常处理
 * 因为程序异常已经在ResponseAspect里面处理过了
 * 此处处理的只是映射错误异常
 * <p>
 * 若要全局映射异常生效
 * 需要再application.yml中禁用SpringBoot原有的处理方式:
 * spring.mvc.throw-exception-if-no-handler-found = true
 * spring.resources.add-mappings = false
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Value("${jwt.header}")
    private String tokenHeader;


    @ExceptionHandler(Exception.class)
    public DataResult errorHandler(Exception e) {


        DataResult dataResult;
        HttpServletRequest request = SpringContextHolder.getRequest();
        ErrorLog errorLog = initErrorLog(request);
        //如果是路径映射错误,直接返回给前端
        if (e instanceof NoHandlerFoundException) {
            dataResult = DataResult.create(ExceptionStatusEnum.E_NOSUCHMETHOD.getCode(),
                    ExceptionStatusEnum.E_NOSUCHMETHOD.getMessage());

        } else if (e instanceof InvocationTargetException) {
            dataResult = DataResult.create(ExceptionStatusEnum.E_INVOCATIONTARGET.getCode(),
                    ExceptionStatusEnum.E_INVOCATIONTARGET.getMessage());

        } else if (e instanceof BeansException) {
            dataResult = DataResult.create(ExceptionStatusEnum.E_BEANS.getCode(),
                    ExceptionStatusEnum.E_BEANS.getMessage());

        } else if (e instanceof NoSuchMethodException) {
            dataResult = DataResult.create(ExceptionStatusEnum.E_NOSUCHMETHOD.getCode(),
                    ExceptionStatusEnum.E_NOSUCHMETHOD.getMessage());

        } else {
            dataResult = DataResult.create(ExceptionStatusEnum.E_SERVER.getCode(),
                    ExceptionStatusEnum.E_SERVER.getMessage());
        }

        errorLog.setResult(e.toString());
        log.error(LOG_ERROR,errorLog.toString());

        log.info("--------------------");
        return dataResult;
    }


    public ErrorLog initErrorLog(HttpServletRequest request) {
        ErrorLog errorLog = new ErrorLog();
        errorLog.setId(UUID.randomUUID().toString());
        errorLog.setUrl(SpringContextHolder.getRequest().getRequestURI());
        errorLog.setHeaders(String.format("token:{%s};channel:{%s}",
                request.getHeader(tokenHeader),
                request.getHeader(Constants.HEADER_CHANNEL)));

        errorLog.setParams(request.getParameterMap().toString());
        errorLog.setIp(getIpAddr());
        errorLog.setTime(new Date());
        return errorLog;
    }


}
