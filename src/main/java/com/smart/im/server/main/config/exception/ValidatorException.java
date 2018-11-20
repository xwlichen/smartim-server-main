package com.smart.im.server.main.config.exception;

import com.smart.im.server.main.Constants;

import lombok.Data;

/**
 * 参数校验异常
 */
@Data
public class ValidatorException extends  BaseException{

    private Integer status = Constants.PARAMS_FILE;

    public ValidatorException(String msg) {
        super(msg);
    }

}
