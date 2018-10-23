package com.smart.im.server.main.config.exception;

import com.smart.im.server.main.Constants;
import lombok.Data;

/**
 * 未登录异常
 */
@Data
public class LoginFilterException extends BaseException{

    private Integer status = Constants.STATUS_NOLOGIN;

    public LoginFilterException(String msg) {
        super(msg);
    }

}
