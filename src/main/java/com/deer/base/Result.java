package com.deer.base;

import com.deer.utils.enums.ResultCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lujy
 * @version 1.0
 * @date 2020/10/16 12:58
 */
@Data
public class Result implements Serializable {

    private Integer code;
    private String message;
    private Object data;

    public Result() {
    }

    public Result(ResultCode resultCode, Object data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public static Result success() {
        return new Result(ResultCode.SUCCESS, null);
    }

    public static Result success(Object data) {
        return new Result(ResultCode.SUCCESS, data);
    }

    public static Result failure(ResultCode resultCode) {
        return new Result(resultCode, null);
    }

    public static Result  failure(ResultCode resultCode, Object data) {
        return new Result(resultCode, data);
    }

}
