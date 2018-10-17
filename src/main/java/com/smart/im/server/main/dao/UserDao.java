package com.smart.im.server.main.dao;

import com.smart.im.server.main.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
	public User getUserById01(String phonenum);
	public User getUserById02(String phonenum);
	

}
