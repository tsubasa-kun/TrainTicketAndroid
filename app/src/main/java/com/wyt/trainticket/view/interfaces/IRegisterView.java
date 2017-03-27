package com.wyt.trainticket.view.interfaces;

/**
 * Created by cookie on 2017/3/27.
 * <p>
 * 注册页View接口
 */

public interface IRegisterView {
    /**
     * 注册
     */
    void doRegister();

    /**
     * 注册成功
     */
    void registerSuccess();

    /**
     * 注册失败
     */
    void registerFailed();
}
