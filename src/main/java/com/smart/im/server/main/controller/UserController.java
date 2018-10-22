package com.smart.im.server.main.controller;


import com.smart.im.server.main.entity.DataResult;
import com.smart.im.server.main.redis.RedisHelper;
import com.smart.im.server.main.secruity.JwtTokenUtil;
import com.smart.im.server.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	RedisHelper redisHelper;

	@Value("${jwt.header}")
	private String tokenHeader;

	@Value("${jwt.tokenHead}")
	private String tokenHead;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;


//	@Resource
//	private UserDao userDao;

	@RequestMapping("/login")
	@ResponseBody
	public DataResult login(String phonenum, String password,
							HttpSession session) {

		try {
			System.out.println("xwxwxwx-request: login");
			DataResult result = null;
			result = userService.checkLogin(phonenum,password, session);
			redisHelper.valuePut("data_user",result);
			redisHelper.listPush("usr",result);
			return result;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/registe")
	@ResponseBody
	public DataResult registe(String phonenum, String password) throws Exception {
		DataResult result = userService.registe(phonenum, password);
		return result;
	}



	@RequestMapping("/info")
	@ResponseBody
	public DataResult getUserinfo(HttpServletRequest request) {

		try {
			System.out.println("xwxwxwx-request: info");

			DataResult result = null;
			String id="";
			String authHeader = request.getHeader(this.tokenHeader);
//			if (authHeader != null && authHeader.startsWith(tokenHead)) {
//				final String authToken = authHeader.substring(tokenHead.length()); // The part after "Bearer "
				 id = jwtTokenUtil.getUsernameFromToken(authHeader);

//			}
			result = userService.getUserInfo(id);
			redisHelper.valuePut("data_user",result);
			redisHelper.listPush("usr",result);
			return result;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



}
