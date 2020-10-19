package com.deer.utils.enums;

/**
 * @author lujy
 * @version 1.0
 * @date 2020/10/16 12:38
 * 状态码枚举
 */
public enum ResultCode {

    /*成功状态码*/
    SUCCESS(1,"成功"),
    /*参数错误：1001-1999*/
    PARAM_IS_INVALID(1001,"参数无效"),
    PARAM_IS_BLANK(1002,"参数为空"),
    PARAM_TYPE_BIND_ERROR(1003,"参数类型错误"),
    PARAM_NOT_COMPLETE(1004,"参数缺失"),
    /*用户错误*/
    USER_NOT_LOGIN(2001,"用户未登录,请登录"),
    USER_LOGIN_ERROR(2002,"账户不存在或密码错误"),
    USER_ACCOUNT_FORBID(2003,"账户已被禁用"),
    USER_NOT_EXISTS(2004,"用户不存在"),
    USER_HAS_EXISTED(2005,"用户已存在");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
