package com.smart.im.server.main.service;


import com.smart.im.server.main.dao.UserDao;
import com.smart.im.server.main.entity.DataResult;
import com.smart.im.server.main.entity.User;
import com.smart.im.server.main.secruity.JwtTokenUtil;
import com.smart.im.server.main.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserDao userDao;
	private AuthenticationManager authenticationManager;
	@Qualifier("jwtUserDetailsServiceImpl")
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;



//	@Autowired
//	public AuthServiceImpl(
//			AuthenticationManager authenticationManager,
//			UserDetailsService userDetailsService,
//			JwtTokenUtil jwtTokenUtil,
//			UserRepository userRepository) {
//		this.authenticationManager = authenticationManager;
//		this.userDetailsService = userDetailsService;
//		this.jwtTokenUtil = jwtTokenUtil;
//		this.userRepository = userRepository;
//	}

	@Autowired
	public UserServiceImp(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}




	public DataResult checkLogin(String phonenum,String password,
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


		UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(phonenum, password);
		// Perform the security
		final Authentication authentication = authenticationManager.authenticate(upToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Reload password post-security so we can generate token
		final UserDetails userDetails = userDetailsService.loadUserByUsername(phonenum);
		final String token = jwtTokenUtil.generateToken(userDetails);

        result.code=1;
        result.message="登录成功";
		result.object=token;
		return result;
	}


	@Autowired
	private static PasswordEncoder passwordEncoder ;



	public DataResult registe(String phonenum, String password) throws Exception {
		DataResult result = new DataResult();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		User user=new User();
		user.setId(phonenum);
		user.setPassword(encoder.encode(password));
		//检测用户名是否被占用
		userDao.insertUser(user);
        result.code=1;
        result.message="注册成功";
		return result;
	}

	@Override
	public DataResult getUserInfo(String phonenum) {
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


		result.code=1;
		result.message="请求成功";
		result.object=user;
		return result;
	}


}
