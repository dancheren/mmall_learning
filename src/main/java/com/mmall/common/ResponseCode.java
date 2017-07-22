package com.mmall.common;

/**
 * Created by 76911 on 2017/7/12.
 */
public enum ResponseCode {
    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEGAL_ARGUMENTS(2,"ILLEGAL_ARGUMENTS");

    private final int code;
    private final String desc;
    ResponseCode(int code,String desc){
        this.code =code;
        this.desc = desc;
    }
    public int getCode(){
        return this.code;
    }
    public String getDesc(){
        return this.desc;
    }
}
