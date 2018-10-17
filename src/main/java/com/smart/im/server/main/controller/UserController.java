package com.smart.im.server.main.controller;


import com.smart.im.server.main.entity.DataResult;
import com.smart.im.server.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/user")
public class UserController extends HttpServlet {
	@Autowired
	private UserService userService;

//	@Resource
//	private UserDao userDao;

	@RequestMapping("/login")
	@ResponseBody
	public DataResult login(String phonenum, String password,
							HttpSession session) {

		try {
			DataResult result = null;
			result = userService.checkLogin(phonenum, session);
			return result;

//			DataResult result = new DataResult();
//			User user = userDao.getUserById01(phonenum);
//			if(user==null){
//				result.code=0;
//				result.message="该用户未注册!";
//			}else {
//				result.code=1;
//				result.message="登录成功";
//				result.object=user;
//			}
//			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/registe")
	@ResponseBody
	public DataResult registe(String phonenum, String password) throws Exception {
//		DataResult result = userService.registe(phonenum, password);
		return null;
	}




}
