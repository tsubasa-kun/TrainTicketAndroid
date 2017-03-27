package com.love_cookies.cookie_library.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by xiekun on 2016/11/11 0011.
 *
 * 手机设备工具类
 * 获取手机IMEI
 */
public class PhoneUtils {

    /**
     * 获取手机IMEI
     * 需要 android.permission.READ_PHONE_STATE 权限
     * @param context
     * @return
     */
    public static String getIMEI(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            String IMEI = telephonyManager.getDeviceId().toLowerCase();
            return IMEI;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}
