package com.example.utils;

import com.example.domain.Result;
import com.example.handle.ExceptionHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by cw on 2017/5/11.
 */
public class ResultUtil {


    public static Result success(Object object) {
        Result result =new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);

        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);

        return result;
    }

}
