package com.travel.travel.util;

import lombok.Data;

@Data
public class ReturnUtil {
    private ReturnUtil(){}
    private int code;
    private String msg;
    private Object data;
    public static ReturnUtil createReturnUtil(int code,String msg,Object data){
        ReturnUtil returnUtil = new ReturnUtil();
        returnUtil.setCode(code);
        returnUtil.setMsg(msg);
        returnUtil.setData(data);
        return returnUtil;
    }
}
