package com.wyt.trainticket.model.biz.interfaces;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.UserBean;

/**
 * Created by Cookie on 2017/3/30.
 * <p>
 * description：修改密码逻辑接口
 */

public interface IResetPasswordBiz {
    /**
     * 修改密码
     * @param userBean
     * @param newPassword
     * @param callBack
     */
    void doReset(UserBean userBean, String newPassword, CallBack callBack);
}
