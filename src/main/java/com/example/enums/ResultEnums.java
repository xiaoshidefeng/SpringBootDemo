package com.example.enums;

/**
 * Created by cw on 2017/5/11.
 */
public enum  ResultEnums {

    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    AGE_LOWER_TEN(100, "年龄小于10 "),
    TEN_AND_TWENT(101, "10-20")

    ;

    private Integer code;

    private String msg;

    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
