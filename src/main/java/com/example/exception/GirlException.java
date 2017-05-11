package com.example.exception;

import com.example.enums.ResultEnums;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by cw on 2017/5/11.
 */
public class GirlException extends RuntimeException{

    private Integer code;


    public GirlException(ResultEnums resultEnums) {
        super(resultEnums.getMsg());
        this.code = resultEnums.getCode();
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
