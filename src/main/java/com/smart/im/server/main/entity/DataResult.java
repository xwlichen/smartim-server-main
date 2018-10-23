package com.smart.im.server.main.entity;

import com.smart.im.server.main.eums.StatusEnum;
import com.smart.im.server.main.utils.CommonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
    private String code;
    private String message;
    private T data;

    public DataResult() {
    }


    public DataResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public DataResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public static <T> DataResult<T> create(StatusEnum statusEnum) {
        return new DataResult<T>(statusEnum.getCode(), statusEnum.getMessage());
    }

    public static <T> DataResult<T> create(StatusEnum statusEnum, T data) {
        return new DataResult<T>(statusEnum.getCode(), statusEnum.getMessage(), data);
    }

    public static <T> DataResult<T> create(StatusEnum statusEnum, String message, T data) {

        return new DataResult<T>(statusEnum.getCode(), message, data);
    }

    public static <T> DataResult<T> createSuccess(T data) {
        return new DataResult<T>(StatusEnum.SUCCESS.getCode(), StatusEnum.SUCCESS.getMessage(),data);
    }

    public static <T> DataResult<T> createSuccess(String message) {
        return new DataResult<T>(StatusEnum.SUCCESS.getCode(), CommonUtil.isNullOrEmpty(message) ? StatusEnum.SUCCESS.getMessage() : message);
    }
    public static <T> DataResult<T> createSuccess(String message, T data) {
        return new DataResult<T>(StatusEnum.SUCCESS.getCode(), CommonUtil.isNullOrEmpty(message) ? StatusEnum.SUCCESS.getMessage() : message, data);
    }

    public static <T> DataResult<T> createFail(String message) {
        return new DataResult<T>(StatusEnum.FAIL.getCode(), CommonUtil.isNullOrEmpty(message) ? StatusEnum.FAIL.getMessage() : message);
    }
    public static <T> DataResult<T> createFail(String message, T t) {
        return new DataResult<T>(StatusEnum.FAIL.getCode(), CommonUtil.isNullOrEmpty(message) ? StatusEnum.FAIL.getMessage() : message, t);
    }



}

