package com.smart.im.server.main.entity;

import com.smart.im.server.main.eums.ApiStatusEnum;
import com.smart.im.server.main.utils.CommonUtil;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : lichen
 * @date : 2018/10/17 下午4:16
 * @email : 1960003945@qq.com
 * @descriotion : 返回的数据结果格式
 */
@Data
@ApiModel(description = "返回响应数据")
public class DataResult<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public DataResult() {
    }


    public DataResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public DataResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }




    public static <T> DataResult<T> create(int  code,String message) {
        return new DataResult<T>(code, message);
    }




    public static <T> DataResult<T> create(ApiStatusEnum statusEnum) {
        return new DataResult<T>(statusEnum.getCode(), statusEnum.getMessage());
    }

    public static <T> DataResult<T> create(ApiStatusEnum statusEnum, T data) {
        return new DataResult<T>(statusEnum.getCode(), statusEnum.getMessage(), data);
    }

    public static <T> DataResult<T> create(ApiStatusEnum statusEnum, String message, T data) {

        return new DataResult<T>(statusEnum.getCode(), message, data);
    }




    public static <T> DataResult<T> createSuccess(T data) {
        return new DataResult<T>(ApiStatusEnum.SUCCESS.getCode(), ApiStatusEnum.SUCCESS.getMessage(),data);
    }

    public static <T> DataResult<T> createSuccess(String message) {
        return new DataResult<T>(ApiStatusEnum.SUCCESS.getCode(), CommonUtil.isNullOrEmpty(message) ? ApiStatusEnum.SUCCESS.getMessage() : message);
    }
    public static <T> DataResult<T> createSuccess(String message, T data) {
        return new DataResult<T>(ApiStatusEnum.SUCCESS.getCode(), CommonUtil.isNullOrEmpty(message) ? ApiStatusEnum.SUCCESS.getMessage() : message, data);
    }

    public static <T> DataResult<T> createFail(String message) {
        return new DataResult<T>(ApiStatusEnum.FAIL.getCode(), CommonUtil.isNullOrEmpty(message) ? ApiStatusEnum.FAIL.getMessage() : message);
    }
    public static <T> DataResult<T> createFail(String message, T t) {
        return new DataResult<T>(ApiStatusEnum.FAIL.getCode(), CommonUtil.isNullOrEmpty(message) ? ApiStatusEnum.FAIL.getMessage() : message, t);
    }



}

