//package com.smart.im.server.main.config.aspect;
//
//import com.smart.im.server.main.Constants;
//import com.smart.im.server.main.config.exception.BaseException;
//import com.smart.im.server.main.config.exception.CommonException;
//import com.smart.im.server.main.utils.CommonUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.beans.BeansException;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.lang.reflect.InvocationTargetException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author : lichen
// * @date : 2018/10/23 下午4:05
// * @email : 1960003945@qq.com
// * @descriotion :
// */
//@Slf4j//引入日志
//@Aspect//声明切面
//@Component//声明组件
//@Order(2)//指定多个切面执行顺序
//@Transactional
////声明事务
//public class ResponseHandlerAspect {
//
//    //定义切点
//    @Pointcut("execution(public * com.smart.im.server.main.controller.*.*(..))")
//    public void apiLog() {
//    }
//
//    //定义切面
//    @Around("apiLog()")
//    public Map<String, Object> around(ProceedingJoinPoint pjp) throws Exception{
//
//        //获取AdapterController的请求参数,分别是channel,module,method,requestDate
//        Object[] args = pjp.getArgs();
//
//        String channel = args[0].toString();
//
//        //封装响应结果
//        Map<String, Object> map = new HashMap<>();
//        Integer status = Constants.STATUS_OK;
//        String  message = Constants.SUCCESS_STR;
//        Object data = null;
//        try {
//
//            //如果请求来源为空,或者请求来源不是预定义的请求来源,则抛出异常
//            if (CommonUtil.isNullOrEmpty(channel) || (!channel.equals(Constants.API_CHANNEL_ADMIN)
//                    && !channel.equals(Constants.API_CHANNEL_ANDRIID) && !channel.equals(Constants.API_CHANNEL_IOS)
//                    && !channel.equals(Constants.API_CHANNEL_WEB))) {
//                throw new CommonException(Constants.NO_CHANNEL_STR);
//            }
//
//            //执行真正的请求
//            data =  pjp.proceed();
//
//        } catch (CommonException e) {
//            status = Constants.NO_CHANNEL;
//            message = Constants.NO_CHANNEL_STR;
//        } catch (BeansException e) {
//            status = Constants.NO_BEANS;
//            message = Constants.NO_BEANS_STR;
//        } catch (NoSuchMethodException e) {
//            status = Constants.NO_METHOD;
//            message = Constants.NO_METHOD_STR;
//        } catch (InvocationTargetException e) {
//
//            if (e.getTargetException() instanceof BaseException) {
//
//                //使用多态,运行时获取对应的exception,将exception对应的status状态码与错误信息返回给前端
//                BaseException baseException = (BaseException) e.getTargetException();
//                status = baseException.getStatus();
//                message = e.getTargetException().getMessage();
//
//            } else {
//
//                //其他错误
//                status = Constants.INNER_ERROR;
//                message = Constants.INNER_ERROR_STR;
//
//                //如果是其他错误,或者exception,将exception携带至前端,以便调试
//                map.put(Constants.EXCEPTION_STR, e.getTargetException().getStackTrace().toString());
//
//                log.error("InvocationTargetException {}", e);
//            }
//
//        } catch (Exception e) {
//
//            status = Constants.OTHER_ERROR;
//            message = Constants.OTHER_ERROR_STR;
//
//            //如果是其他错误,或者exception,将exception携带至前端,以便调试
//            map.put(Constants.EXCEPTION_STR, e.getStackTrace().toString());
//
//            log.error("Exception {}", e.getStackTrace().toString());
//        }catch (Throwable throwable) {
//            throwable.printStackTrace();
//            if (log.isDebugEnabled()) {
//                log.error("保存记录出错 {}",throwable);
//            }
//            map.put(Constants.STATUS_STR,500);
//            map.put(Constants.MESSAGE_STR,"请求异常,Throwable错误");
//            throw new Exception();
//        }
//        map.put(Constants.STATUS_STR,status);
//        map.put(Constants.MESSAGE_STR,message);
//        map.put(Constants.DATA_STR,data);
//
//        return map;
//    }
//}