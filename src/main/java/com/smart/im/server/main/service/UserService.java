package com.smart.im.server.main.service;


import com.smart.im.server.main.entity.DataResult;



public interface UserService {
	 DataResult login(String account, String password);
	 DataResult registe(String account, String password);

	 DataResult getUserInfo(String phonenum);

	

}
