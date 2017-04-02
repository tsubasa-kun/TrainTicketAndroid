package com.wyt.trainticket.utils;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

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
        Date currentDate = new Date(System.currentTimeMillis());
        return formatter.format(currentDate);
    }

    /**
     * 获取当前日期
     */
    public String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        Date currentDate = new Date(System.currentTimeMillis());
        return formatter.format(currentDate);
    }

    /**
     * 时间转为时间戳
     * @param time
     * @return
     */
    public String dataToTimestamp(String time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        Date date;
        String timestamp = null;
        try {
            date = formatter.parse(time);
            long l = date.getTime();
            String stf = String.valueOf(l);
            timestamp = stf.substring(0, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return timestamp;
    }

}
