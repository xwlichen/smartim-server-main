package com.smart.im.server.main.service;


import com.smart.im.server.main.entity.DataResult;

import javax.servlet.http.HttpSession;


public interface UserService {
	public DataResult checkLogin(String id, HttpSession session)throws Exception;
	public DataResult registe(String id, String password)throws Exception;

	

}
