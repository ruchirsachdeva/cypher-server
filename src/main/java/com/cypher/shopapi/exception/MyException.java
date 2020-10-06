package com.cypher.shopapi.exception;


import com.cypher.shopapi.enums.ResultEnum;

/**
 * Created By Ruchir Sachdeva on 3/10/2018.
 */
public class MyException extends RuntimeException {

    private Integer code;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
