package com.smart.im.server.main.base;

import com.smart.im.server.main.eums.StatusEnum;
import io.netty.util.internal.StringUtil;

import java.io.Serializable;

/**
 * @author : lichen
 * @date : 2018/10/17 下午4:16
 * @email : 1960003945@qq.com
 * @descriotion :
 */
public class BaseResponse <T> implements Serializable {
    private String code;

    private String message;

    /**
     * 请求号
     */
    private String reqNo;

    private T messageBody;

    public BaseResponse() {}

    public BaseResponse(T messageBody) {
        this.messageBody = messageBody;
    }

    public BaseResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(String code, String message, T messageBody) {
        this.code = code;
        this.message = message;
        this.messageBody = messageBody;
    }

    public BaseResponse(String code, String message, String reqNo, T messageBody) {
        this.code = code;
        this.message = message;
        this.reqNo = reqNo;
        this.messageBody = messageBody;
    }

    public static <T> BaseResponse<T> create(T t){
        return new BaseResponse<T>(t);
    }

    public static <T> BaseResponse<T> create(T t, StatusEnum statusEnum){
        return new BaseResponse<T>(statusEnum.getCode(), statusEnum.getMessage(), t);
    }

    public static <T> BaseResponse<T> createSuccess(T t, String message){
        return new BaseResponse<T>(StatusEnum.SUCCESS.getCode(), StringUtil.isNullOrEmpty(message) ? StatusEnum.SUCCESS.getMessage() : message, t);
    }

    public static <T> BaseResponse<T> createFail(T t, String message){
        return new BaseResponse<T>(StatusEnum.FAIL.getCode(), StringUtil.isNullOrEmpty(message) ? StatusEnum.FAIL.getMessage() : message, t);
    }

    public static <T> BaseResponse<T> create(T t, StatusEnum statusEnum, String message){

        return new BaseResponse<T>(statusEnum.getCode(), message, t);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(T messageBody) {
        this.messageBody = messageBody;
    }

    public String getReqNo() {
        return reqNo;
    }

    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", reqNo='" + reqNo + '\'' +
                ", messageBody=" + messageBody +
                '}';
    }
}

