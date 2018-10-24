package com.smart.im.server.main.utils;


import com.smart.im.server.main.Constants;
import com.smart.im.server.main.dao.mybatis.model.ErrorLog;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.UUID;

public class CommonUtil {

    public static String md5(String msg) throws NoSuchAlgorithmException {
        //利用md5对msg处理
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] input = msg.getBytes();
        byte[] output = md.digest(input);
        //return new String(output);
        //将md5处理的output结果转成字符串
        String result = msg;
        return result;
    }


    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }






}
