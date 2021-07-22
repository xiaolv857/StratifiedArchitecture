package com.xiaolv.stratifiedarchitectureproject.mybatis.enums;

/**
 * @author heji-01
 */

public enum HttpCode {

    /**
     * 判断
     */
    SUCCESS(1,"成功"),

    FAIL(-1,"失败"),

    EXCEPTION(500,"系统异常");


    private int code;

    private  String msg;

    HttpCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
