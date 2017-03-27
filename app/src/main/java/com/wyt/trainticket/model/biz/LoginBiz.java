package com.wyt.trainticket.model.biz;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.UserBean;
import com.wyt.trainticket.model.biz.interfaces.ILoginBiz;

/**
 * Created by cookie on 2017/3/17 0017.
 * <p>
 * 登录逻辑
 */
public class LoginBiz implements ILoginBiz {

    /**
     * 登录
     *
     * @param userBean 用户实体类
     * @param callBack 回调
     */
    @Override
    public void doLogin(UserBean userBean, CallBack callBack) {
        String account = userBean.getAccount();
        String password = userBean.getPassword();
        callBack.onSuccess(userBean);
    }

}
