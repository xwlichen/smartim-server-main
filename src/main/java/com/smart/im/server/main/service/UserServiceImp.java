package com.smart.im.server.main.service;


import com.smart.im.server.main.Messages;
import com.smart.im.server.main.config.secruity.JwtTokenUtil;
import com.smart.im.server.main.dao.UserDao;
import com.smart.im.server.main.entity.DataResult;
import com.smart.im.server.main.entity.bean.User;
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
    private static PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImp(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    /**
     * 登录
     *
     * @param account  账号
     * @param password 密码
     * @return
     */
    public DataResult login(String account, String password) {
        User user = userDao.getUserById01(account);
        if (user == null) {
            return DataResult.createFail(Messages.MSG_NO_REGISTER);

        }

        if (CommonUtil.isNullOrEmpty(user.getId())) {
            return DataResult.createFail(Messages.MSG_NO_REGISTER);
        }

        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(account, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(account);
        final String token = jwtTokenUtil.generateToken(userDetails);

        LoginResponse response = new LoginResponse();
        response.setToken(token);
        response.setUser(user);
        return DataResult.createSuccess(Messages.MSG_LOGIN_SUCCESS, response);
    }


    /**
     * 注册
     *
     * @param account  账号
     * @param password 密码
     * @return
     */
    public DataResult registe(String account, String password) {
        DataResult result = new DataResult();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setId(account);
        user.setPassword(encoder.encode(password));
        //检测用户名是否被占用
        userDao.insertUser(user);
        return DataResult.createSuccess(Messages.MSG_REGISTER_SUCESS);
    }

    @Override
    public DataResult getUserInfo(String phonenum) {
        DataResult result = new DataResult();
        User user = userDao.getUserById01(phonenum);
        if (user == null && CommonUtil.isNullOrEmpty(user.getId())) {
            return DataResult.createFail(Messages.MSG_NO_REGISTER);
        }
        LoginResponse response = new LoginResponse();
        response.setUser(user);
        return DataResult.createSuccess(response);
    }


}
