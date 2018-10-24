package com.smart.im.server.main.controller.app;


import com.smart.im.server.main.config.redis.RedisHelper;
import com.smart.im.server.main.config.secruity.JwtTokenUtil;
import com.smart.im.server.main.entity.DataResult;
import com.smart.im.server.main.entity.reponse.LoginResponse;
import com.smart.im.server.main.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Api(value = "UserController", description = "用户模块")
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    RedisHelper redisHelper;

    @Value("${jwt.header}")
    private String tokenHeader;


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

//    @ApiImplicitParam(name ="id",value = "学生id",paramType = "path",required = true,dataType = "String")  @PathVariable


    @ApiOperation(value = "用户登录", notes = "用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phonenum", value = "用户名", required = true, dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "string")
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public DataResult<LoginResponse> login(String phonenum, String password) {

        try {
            DataResult result = null;
            result = userService.login(phonenum, password);
            redisHelper.valuePut("data_user", result);
            redisHelper.listPush("usr", result);
            return result;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/registe", method = RequestMethod.POST)
    @ResponseBody
    public DataResult registe(String phonenum, String password) throws Exception {
        DataResult result = userService.registe(phonenum, password);
        return result;
    }


    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public DataResult getUserinfo(HttpServletRequest request) {

        try {
            System.out.println("xwxwxwx-request: info");

            DataResult result = null;
            String id = "";
            String authHeader = request.getHeader(this.tokenHeader);
//			if (authHeader != null && authHeader.startsWith(tokenHead)) {
//				final String authToken = authHeader.substring(tokenHead.length()); // The part after "Bearer "
            id = jwtTokenUtil.getUsernameFromToken(authHeader);

//			}
            result = userService.getUserInfo(id);
            redisHelper.valuePut("data_user", result);
            redisHelper.listPush("usr", result);
            return result;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


}
