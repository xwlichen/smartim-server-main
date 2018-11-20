package com.smart.im.server.main.dao;

import com.smart.im.server.main.entity.bean.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
	 User getUserById01(String phonenum);
	 User getUserById02(String phonenum);

	 void insertUser(User user);


	//根据手机号查询
	User queryUserByPhoneNum(String phonenum);
	

}
