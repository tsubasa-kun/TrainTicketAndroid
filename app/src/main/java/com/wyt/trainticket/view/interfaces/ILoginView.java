package com.wyt.trainticket.view.interfaces;

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
     * 跳转到主页
     */
    void turnToMain();

    /**
     * 登录失败
     */
    void loginFailed();

    /**
     * 自动登录
     */
    void autoLogin();
}
