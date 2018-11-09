package com.smart.im.server.main.controller;

import com.smart.im.server.main.config.redis.RedisHelper;
import com.smart.im.server.main.config.secruity.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author : lichen
 * @date : 2018/10/24 下午4:36
 * @email : 1960003945@qq.com
 * @descriotion :Controller 基类
 */
public class BaseController {

    //redis工具类
    @Autowired
    public RedisHelper redisHelper;

    //token头标识
    @Value("${jwt.header}")
    public String tokenHeader;


    //jwt token 工具类
    @Autowired
    public JwtTokenUtil jwtTokenUtil;
}
