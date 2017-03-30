package com.wyt.trainticket.model.biz;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.UserBean;
import com.wyt.trainticket.model.biz.interfaces.IResetPasswordBiz;

/**
 * Created by Cookie on 2017/3/30.
 * <p>
 * description：修改密码逻辑
 */

public class ResetPasswordBiz implements IResetPasswordBiz {
    /**
     * 修改密码
     * @param userBean
     * @param newPassword
     * @param callBack
     */
    @Override
    public void doReset(UserBean userBean, String newPassword, CallBack callBack) {
        callBack.onSuccess(userBean);
    }
}
