package com.mantishell.exception;

/**
 * 自定义异常类
 */
public class SimpleException extends  Exception {
    //存储提示信息
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SimpleException(String message) {
        this.message = message;
    }
}
