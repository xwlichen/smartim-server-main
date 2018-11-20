package com.smart.im.server.main.entity;

import lombok.Data;

/**
 * @author lichen
 * @date ：2018/11/9 下午4:21
 * @email : 196003945@qq.com
 * @description :基类请求
 */
@Data
public class BaseRequest {

    //token
    private String token;
    //分页索引
    private int pageIndex;
    //分页大小
    private int pageSize;
}
