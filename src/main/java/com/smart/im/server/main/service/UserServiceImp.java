package com.smart.im.server.main.service;


import com.smart.im.server.main.config.secruity.JwtTokenUtil;
import com.smart.im.server.main.dao.UserDao;
import com.smart.im.server.main.entity.DataResult;
import com.smart.im.server.main.entity.User;
import com.smart.im.server.main.entity.reponse.LoginResponse;
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





	@Autowired
	public UserServiceImp(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}




	public DataResult login(String phonenum, String password)  {
		User user = userDao.getUserById01(phonenum);
		if(user==null&&CommonUtil.isNullOrEmpty(user.getId())){
			return DataResult.createFail("该用户未注册!");
		}
		UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(phonenum, password);
		final Authentication authentication = authenticationManager.authenticate(upToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final UserDetails userDetails = userDetailsService.loadUserByUsername(phonenum);
		final String token = jwtTokenUtil.generateToken(userDetails);

		LoginResponse response=new LoginResponse();
		response.setToken(token);
		response.setUser(user);
		return DataResult.createSuccess("登陆成功",response);
	}


	@Autowired
	private static PasswordEncoder passwordEncoder ;



	public DataResult registe(String phonenum, String password) {
		DataResult result = new DataResult();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		User user=new User();
		user.setId(phonenum);
		user.setPassword(encoder.encode(password));
		//检测用户名是否被占用
		userDao.insertUser(user);
		return DataResult.createSuccess("注册成功");
	}

	@Override
	public DataResult getUserInfo(String phonenum) {
		DataResult result = new DataResult();
		User user = userDao.getUserById01(phonenum);
		if(user==null&&CommonUtil.isNullOrEmpty(user.getId())) {
			return DataResult.createFail("该用户未注册!");
		}
			LoginResponse response=new LoginResponse();
			response.setUser(user);
		return DataResult.createSuccess(response);
	}


}
