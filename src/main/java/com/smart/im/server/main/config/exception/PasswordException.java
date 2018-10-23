package com.smart.im.server.main.config.exception;

import com.smart.im.server.main.Constants;
import lombok.Data;


/**
 * 密码错误异常
 */
@Data
public class PasswordException extends BaseException{

    private Integer status = Constants.PASSWORD_WRONG;

    public PasswordException(String msg) {
        super(msg);
    }

}
