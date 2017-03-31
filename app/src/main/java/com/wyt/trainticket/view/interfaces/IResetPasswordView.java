package com.wyt.trainticket.view.interfaces;

import com.wyt.trainticket.model.bean.UserBean;

/**
 * Created by Cookie on 2017/3/30.
 * <p>
 * description：修改密码View接口
 */

public interface IResetPasswordView {
    /**
     * 修改密码
     */
    void doReset();

    /**
     * 修改成功
     * @param userBean
     */
    void resetSuccess(UserBean userBean);

    /**
     * 修改失败
     * @param msg
     */
    void resetFailed(String msg);
}
