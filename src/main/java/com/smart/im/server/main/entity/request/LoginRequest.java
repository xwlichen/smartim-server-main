package com.smart.im.server.main.entity.request;

import lombok.Data;

/**
 * @author : lichen
 * @date : 2018/10/23 下午1:49
 * @email : 1960003945@qq.com
 * @descriotion :登陆的请求参数
 */

@Data
public class LoginRequest {
    private int phonenum;
    private String passwrod;
}
