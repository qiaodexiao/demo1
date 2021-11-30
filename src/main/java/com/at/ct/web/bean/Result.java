package com.at.ct.web.bean;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private String MESSAGE;
    private int CODE;
    private T DATA;
    private Result(T data) {
        this.CODE = 200;
        this.MESSAGE = "success";
        this.DATA = data;
    }
    private Result(String message, T data) {
        this.MESSAGE = message;
        this.CODE = -1;
        this.DATA = data;
    }
    private Result(String message , int retCode, T data) {
        this.MESSAGE = message;
        this.CODE = retCode;
        this.DATA = data;
    }
    /**
     * 成功时候的调用
     * @return
     */
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }
    /**
     * 成功，不需要传入参数
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Result<T> success(){
        return (Result<T>) success("");
    }
    /**
     * 失败时候的调用
     * @return
     */
    public static <T> Result<T> error(String message , int retCode, T data){
        return new Result<T>(message,retCode,data);
    }
    /**
     * 失败时候的调用,扩展消息参数
     * @return
     */
    public static <T> Result<T> error(String message , T data){
        return new Result<T>(message,data);
    }
    public T getData() {
        return DATA;
    }
    public String getMessage() {
        return MESSAGE;
    }
    public int getRetCode() {
        return CODE;
    }

    @Override
    public String toString() {
        return "Result{" +
                "MESSAGE='" + MESSAGE + '\'' +
                ", CODE=" + CODE +
                ", DATA=" + DATA +
                '}';
    }
}
