package com.smart.im.server.main.controller.app;


import com.smart.im.server.main.controller.BaseController;
import com.smart.im.server.main.entity.DataResult;
import com.smart.im.server.main.entity.reponse.LoginResponse;
import com.smart.im.server.main.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@Api(value = "UserController", description = "用户模块")
@RestController
@RequestMapping("/api/user")
public class UserController  extends BaseController {
    @Autowired
    private UserService userService;



//    @ApiImplicitParam(name ="id",value = "学生id",paramType = "path",required = true,dataType = "String")  @PathVariable


    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phonenum", value = "用户名", required = true, dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "string")
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public DataResult<LoginResponse> login(String phonenum, String password) {
            DataResult result;
            result = userService.login(phonenum, password);
            redisHelper.valuePut("data_user", result);
            redisHelper.listPush("usr", result);
            return result;

    }

    @ApiOperation(value = "用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phonenum", value = "用户名", required = true, dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "string")
    })
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
