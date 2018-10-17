package com.smart.im.server.main.service;


import com.smart.im.server.main.dao.UserDao;
import com.smart.im.server.main.entity.DataResult;
import com.smart.im.server.main.entity.User;
import com.smart.im.server.main.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserDao userDao;


	public DataResult checkLogin(String phonenum,
								 HttpSession session) throws Exception {
		DataResult result = new DataResult();
		User user = userDao.getUserById01(phonenum);
		if(user==null){
			result.code=0;
			result.message="该用户未注册!";
			return result;
		}
		//解密
//		String md5_pwd = CommonUtil.md5(password);
		String md5_user_pwd=user.password;
//		if(!md5_user_pwd.equals(md5_pwd)){
//            result.code=0;
//            result.message="帐号或密码错误！";
//			return result;
//		}
		//保存一个用户登录的时间，用于计算在线时长
//		session.setAttribute("logintime", new Date());
//		session.setAttribute("userinfo", user);
//		session.setAttribute("userid", phonenum);
        result.code=1;
        result.message="登录成功";
		result.object=user;
		return result;
	}

	public DataResult registe(String phonenum, String password) throws Exception {
		DataResult result = new DataResult();
		//检测用户名是否被占用
		User has_user = userDao.getUserById02(phonenum);
		if(has_user!=null){
            result.code=0;
            result.message="用户名已被占用";
			return result;
		}
		//注册
		User user = new User();
		user.id= UUID.randomUUID().toString();
		String md5_pwd = CommonUtil.md5(password);//设置加密
		user.password=md5_pwd;
//		user.isenable=1;
//		user.headpic= Constant.CLASSIFY_HEADPIC+Constant.NAME_DEFALUT_HEADPIC;
//
//		userDao.insertUser01(user);
//        result.code=1;
//        result.message="注册成功";
		return result;
	}




}
