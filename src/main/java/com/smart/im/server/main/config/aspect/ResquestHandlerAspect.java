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
//public class ResquestHandlerAspect {
//
//    //定义切点
//    @Pointcut("execution(public * com.smart.im.server.main.controller.*.*.*(..))")
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
//        pjp.get
//
//        String channel = args[0].toString();
//
//        //封装响应结果
//        Map<String, Object> map = new HashMap<>();
//        Integer status = Constants.STATUS_OK;
//        String  message = Constants.SUCCESS_STR;
//        Object data = null;
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
//
//        return map;
//    }
//}