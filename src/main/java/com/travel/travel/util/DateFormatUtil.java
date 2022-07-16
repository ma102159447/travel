package com.travel.travel.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获得当前时间的字符串 yyyy-MM-dd HH:mm:ss
     * @return String
     */
    public static String getNowDateTimeString(){
        return format.format(new Date());
    }
}
