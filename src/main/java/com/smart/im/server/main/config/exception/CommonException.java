package com.smart.im.server.main.config.exception;


import com.smart.im.server.main.Constants;
import lombok.Data;

/**
 * 自定义通用异常信息
 */
@Data
public class CommonException extends BaseException{

    private Integer status = Constants.INNER_ERROR;

    public CommonException(String msg) {
        super(msg);
    }
}
