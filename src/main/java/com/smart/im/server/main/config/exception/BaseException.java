package com.smart.im.server.main.config.exception;

import lombok.Data;

@Data
public class BaseException extends Exception{

    private Integer status = 200;

    public BaseException(String msg) {
        super(msg);
    }
}
