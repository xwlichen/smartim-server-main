package com.smart.im.server.main.eums;

import java.util.ArrayList;
import java.util.List;

/**
 * exception返回结果状态。
 */
public enum ExceptionStatusEnum {

    /**
     * 服务器异常
     */
    E_SERVER(5000, "服务器异常"),

    /**
     * 方法内部执行异常
     */
    E_INVOCATIONTARGET(5001, "方法内部执行异常"),

    /**
     * 目标业务模块不存在
     */
    E_BEANS(5002, "目标业务模块不存在"),

    /**
     * 目标方法不存在
     */
    E_NOSUCHMETHOD(5003, "目标方法不存在"),

    /**
     * 非法的请求渠道
     */
    E_CHANNEL(5004, "非法的请求渠道"),


    /**
     * 请求地址错误,请检查后再次尝试!
     */
    E_NOHANDLERFOUND(5005, "请求地址错误,请检查后再次尝试");


    /**
     * 枚举值码
     */
    private final int code;

    /**
     * 枚举描述
     */
    private final String message;

    /**
     * 构建一个 ApiStatusEnum 。
     *
     * @param code    枚举值码。
     * @param message 枚举描述。
     */
    private ExceptionStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 得到枚举值码。
     *
     * @return 枚举值码。
     */
    public int getCode() {
        return code;
    }

    /**
     * 得到枚举描述。
     *
     * @return 枚举描述。
     */
    public String getMessage() {
        return message;
    }

    /**
     * 得到枚举值码。
     *
     * @return 枚举值码。
     */
    public int code() {
        return code;
    }

    /**
     * 得到枚举描述。
     *
     * @return 枚举描述。
     */
    public String message() {
        return message;
    }

    /**
     * 通过枚举值码查找枚举值。
     *
     * @param code 查找枚举值的枚举值码。
     * @return 枚举值码对应的枚举值。
     * @throws IllegalArgumentException 如果 code 没有对应的 ApiStatusEnum 。
     */
    public static ExceptionStatusEnum findStatus(int code) {
        for (ExceptionStatusEnum status : values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("ResultInfo ApiStatusEnum not legal:" + code);
    }

    /**
     * 获取全部枚举值。
     *
     * @return 全部枚举值。
     */
    public static List<ExceptionStatusEnum> getAllStatus() {
        List<ExceptionStatusEnum> list = new ArrayList<ExceptionStatusEnum>();
        for (ExceptionStatusEnum status : values()) {
            list.add(status);
        }
        return list;
    }

    /**
     * 获取全部枚举值码。
     *
     * @return 全部枚举值码。
     */
    public static List<Integer> getAllStatusCode() {
        List<Integer> list = new ArrayList<Integer>();
        for (ExceptionStatusEnum status : values()) {
            list.add(status.code());
        }
        return list;
    }
}
