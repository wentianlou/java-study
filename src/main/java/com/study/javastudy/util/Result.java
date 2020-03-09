package com.study.javastudy.util;

import java.io.Serializable;

/**
 * 六一信息科技
 *
 * @author: liyingjie
 * @date: 2018-06-20 15:52
 **/
public class Result<T> implements Serializable {

    private final int code;
    private final String msg;
    private final T data;


    public static final Result SUCCESS = new Result(ResultCodeEnum.SUCCESS);
    public static final Result ERR_SYSTEM = new Result(ResultCodeEnum.SYSTEM_ERROR);
    public static final Result ERR_PARAM = new Result(ResultCodeEnum.REQUEST_ERROR);
    public static final Result ERR_FOBIDDEN = new Result(ResultCodeEnum.FORBIDDEN);

    public Result(T data) {
        this(ResultCodeEnum.SUCCESS, data);
    }

    public Result(ResultCodeEnum codeEnum) {
        this(codeEnum.getCode(), codeEnum.getMsg(), null);
    }

    public Result(ResultCodeEnum codeEnum, T data) {
        this(codeEnum.getCode(), codeEnum.getMsg(), data);
    }

    public Result(ResultCodeEnum codeEnum, String msg, T data) {
        this(codeEnum.getCode(), msg, data);
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return this.code == ResultCodeEnum.SUCCESS.getCode();
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
