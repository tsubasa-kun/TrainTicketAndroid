package com.wyt.trainticket.app;

import com.love_cookies.cookie_library.application.BaseApplication;
import com.wyt.trainticket.model.bean.UserBean;

/**
 * Created by cookie on 2017/3/15 0015.
 * <p>
 * 程序的Application类
 */
public class TrainTicketApplication extends BaseApplication {

    public static UserBean user;

    public static void setUser(UserBean user) {
        TrainTicketApplication.user = user;
    }

    public static UserBean getUser() {
        return user;
    }
}
