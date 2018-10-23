package com.smart.im.server.main.service;


import com.smart.im.server.main.entity.DataResult;



public interface UserService {
	 DataResult login(String phonenum, String password);
	 DataResult registe(String id, String password);

	 DataResult getUserInfo(String phonenum);

	

}
