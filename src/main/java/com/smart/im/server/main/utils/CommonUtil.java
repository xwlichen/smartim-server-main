package com.smart.im.server.main.utils;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
