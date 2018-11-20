package com.smart.im.server.main.entity.bean;

import org.springframework.data.annotation.Id;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class User {
	@Id
	@ApiModelProperty(notes = "用户id")
	private String id;
	@ApiModelProperty(notes = "用户密码")
	private String password;
	private String name;
	private Date lastPasswordResetDate;

	private String phonenum;


}
