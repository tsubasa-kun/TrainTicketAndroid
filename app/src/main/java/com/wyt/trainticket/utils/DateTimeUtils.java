package com.wyt.trainticket.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by cookie on 2017/3/17 0017.
 *
 * 获取当前时间
 */
public class DateTimeUtils {
    private static DateTimeUtils instance;

    /**
     * DateTimeUtil
     *
     * @return DateTimeUtil
     */
    public static DateTimeUtils getInstance() {
        if (instance == null) {
            instance = new DateTimeUtils();
        }
        return instance;
    }

    /**
     * 获取当前时间
     */
    public String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date curDate = new Date(System.currentTimeMillis());
        return formatter.format(curDate);
    }

}
