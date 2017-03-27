package com.wyt.trainticket.model.biz.interfaces;

import com.love_cookies.cookie_library.interfaces.CallBack;

/**
 * Created by cookie on 2017/3/17 0017.
 * <p>
 * 登录逻辑接口
 */
public interface ILoginBiz {
    /**
     * 登录
     *
     * @param account  账号
     * @param password 密码
     * @param callBack 回调
     */
    void doLogin(String account, String password, CallBack callBack);
}
