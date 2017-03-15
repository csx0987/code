package com.shengxin.exception;

import com.shengxin.enums.ResultEnum;

/**
 * Created by chenshengxin on 2017/3/14.
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
