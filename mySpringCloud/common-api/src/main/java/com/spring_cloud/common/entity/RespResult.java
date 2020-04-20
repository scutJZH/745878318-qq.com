package com.spring_cloud.common.entity;

public class RespResult<T> {
    private static final Integer SUCCESS_CODE = 0;
    private static final String SUCCESS_MESSAGE = "OK";
    private Integer code;
    private String message;
    private T data;

    public RespResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public RespResult() {
        this.code = SUCCESS_CODE;
        this.message = "OK";
    }

    public RespResult(T data) {
        this.code = SUCCESS_CODE;
        this.message = "OK";
        this.data = data;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
