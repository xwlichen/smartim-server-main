package com.smart.im.server.main.config.exception;

import lombok.Data;

@Data
public class BaseException extends Exception{

    private int code;
    private String message;

    public BaseException(String message){
        this.message=message;
    }

}
