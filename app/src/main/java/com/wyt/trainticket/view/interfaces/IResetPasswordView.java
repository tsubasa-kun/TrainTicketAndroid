package com.wyt.trainticket.view.interfaces;

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
     */
    void resetSuccess();

    /**
     * 修改失败
     */
    void resetFailed();
}
