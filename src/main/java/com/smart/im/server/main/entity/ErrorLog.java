package com.smart.im.server.main.entity;

import lombok.Data;

import java.util.Date;


/**
 * @author : lichen
 * @date : 2018/10/24 上午11:40
 * @email : 1960003945@qq.com
 * @descriotion :错误日志
 */
@Data
public class ErrorLog {

    //id
    private String id;
    //请求url
    private String url;

    //客户端channel
    private String channel;

    //请求头
    private String headers;

    //请求参数
    private String params;

    //结果
    private String result;

    //请求时间
    private Date time;

    //客户端ip
    private String ip;
}
