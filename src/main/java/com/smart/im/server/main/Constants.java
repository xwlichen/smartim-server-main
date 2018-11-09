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



    //  来源渠道
    public static  final String HEADER_CHANNEL="channel";



    public static final String LOG_ERROR="simlog-error {}";






    /**
     * 参数校验失败
     */
    public static final Integer PARAMS_FILE = 207;
    public static final String  PARAMS_FILE_STR = "参数校验失败";








    public static final String API_MAPPER = "api";
    public static final String API_CHANNEL_WEB = "web";
    public static final String API_CHANNEL_ANDRIID = "android";
    public static final String API_CHANNEL_IOS = "ios";
    public static final String API_CHANNEL_ADMIN = "admin";


}
