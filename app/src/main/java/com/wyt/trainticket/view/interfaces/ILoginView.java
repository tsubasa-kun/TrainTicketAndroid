package com.wyt.trainticket.view.interfaces;

import com.wyt.trainticket.model.bean.UserBean;

/**
 * Created by cookie on 2017/3/17 0017.
 * <p>
 * 登录页View接口
 */
public interface ILoginView {
    /**
     * 去登录
     */
    void doLogin();

    /**
     * 登录成功
     * @param userBean
     */
    void loginSuccess(UserBean userBean);

    /**
     * 登录失败
     */
    void loginFailed();

    /**
     * 自动登录
     */
    void autoLogin();
}
