package com.smart.im.server.main.eums;

import java.util.ArrayList;
import java.util.List;

/**
 * api返回结果状态。
 */
public enum ApiStatusEnum{

    /**
     * 成功
     */
    SUCCESS(2000, "成功"),

    /**
     * 失败
     */
    FAIL(2001, "失败"),

    /**
     * 重复请求
     */
    REPEAT_REQUEST(2002, "重复请求"),

    /**
     * 该用户不存在
     */
    ERROR_NOUSER(2003, "该用户不存在"),

    /**
     * 密码错误
     */
    ERROR_PASSWORD(2004, "密码错误"),

    /**
     * 权限错误
     */
    ERROR_AUTH(2005, "权限错误"),

    /**
     * 权限错误
     */
    ERROR_TOKEN(2006, "Token失效")
    ;


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
    private ApiStatusEnum(int code, String message) {
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
    public static ApiStatusEnum findStatus(int code) {
        for (ApiStatusEnum status : values()) {
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
    public static List<ApiStatusEnum> getAllStatus() {
        List<ApiStatusEnum> list = new ArrayList<ApiStatusEnum>();
        for (ApiStatusEnum status : values()) {
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
        for (ApiStatusEnum status : values()) {
            list.add(status.code());
        }
        return list;
    }
}
