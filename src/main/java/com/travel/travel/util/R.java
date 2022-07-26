package com.travel.travel.util;

import lombok.Data;

@Data
public class R <T>{
    private int code;
    private String msg;
    private T data;



    public static <T> R<T> success(T data){
        R<T> r = new R<>();
        r.code = 200;
        r.msg = "success";
        r.data = data;
        return r;
    }
    public static <T> R<T> error(String msg){
        R<T> r = new R<>();
        r.code = 500;
        r.msg = msg;
        return r;
    }
}
