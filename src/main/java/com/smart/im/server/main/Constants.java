package com.smart.im.server.main;

/**
 * Created by 19600 on 2017/1/11.
 */
public class Constants {
    //qiniu 地址
    public static final  String QINIUURL="http://ojleivxnt.bkt.clouddn.com/";

    //分类
    //public static final  String QINIUURL_IMAGE=QINIUURL+"image/";
    public static final String CLASSIFY_HEADPIC="headpic/";
    public static final String CLASSIFY_CARE="care/";

    public static final String NAME_DEFALUT_HEADPIC="defalut_headpic.png";



    public static  final String HEADER_CHANNEL="channel";




    /**
     * 成功
     */
    public static final Integer STATUS_OK = 200;
    public static final String  STATUS_OK_STR = "成功";

    /**
     * 未登录
     */
    public static final Integer STATUS_NOLOGIN = 201;
    public static final String  STATUS_NOLOGIN_STR = "未登录";

    /**
     * token失效
     */
    public static final Integer STATUS_INVALIDTOKEN = 202;
    public static final String  STATUS_INVALIDTOKEN_STR = "token失效";
    /**
     * 密码错误
     */
    public static final Integer PASSWORD_WRONG = 203;
    public static final String  PASSWORD_WRONG_STR = "密码错误";
    /**
     * 方法内部执行异常
     */
    public static final Integer INNER_ERROR = 204;
    public static final String  INNER_ERROR_STR = "方法内部执行异常";

    /**
     * 目标业务模块不存在
     */
    public static final Integer NO_BEANS = 205;
    public static final String  NO_BEANS_STR = "目标业务模块不存在";

    /**
     * 目标方法不存在
     */
    public static final Integer NO_METHOD = 206;
    public static final String  NO_METHOD_STR = "目标方法不存在";

    /**
     * 参数校验失败
     */
    public static final Integer PARAMS_FILE = 207;
    public static final String  PARAMS_FILE_STR = "参数校验失败";

    /**
     * 非法的请求渠道
     */
    public static final Integer NO_CHANNEL = 208;
    public static final String  NO_CHANNEL_STR = "非法的请求渠道";
    /**
     * 服务器异常
     */
    public static final Integer OTHER_ERROR = 500;
    public static final String  OTHER_ERROR_STR = "服务器异常";

    public static final String STATUS_STR = "status";
    public static final String SERVICE_SUF = "ServiceImpl";
    public static final String DATA_STR = "data";
    public static final String MESSAGE_STR = "message";
    public static final String BLANK_STR = "";
    public static final String EXCEPTION_STR = "exception";
    public static final String SUCCESS_STR = "success";

    public static final String METHOD_MAPPER = "/{channel}/{serviceName}/{methodName}";
    public static final String API_MAPPER = "api";
    public static final String API_CHANNEL_WEB = "web";
    public static final String API_CHANNEL_ANDRIID = "android";
    public static final String API_CHANNEL_IOS = "ios";
    public static final String API_CHANNEL_ADMIN = "admin";


}
