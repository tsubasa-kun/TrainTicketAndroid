package com.wyt.trainticket.presenter;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.UserBean;
import com.wyt.trainticket.model.biz.LoginBiz;
import com.wyt.trainticket.view.interfaces.ILoginView;

/**
 * Created by cookie on 2017/3/17 0017.
 * <p>
 * 登录Presenter
 */
public class LoginPresenter {

    private LoginBiz loginBiz;
    private ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        loginBiz = new LoginBiz();
        this.iLoginView = iLoginView;
    }

    /**
     * 去登录
     *
     * @param userBean
     */
    public void doLogin(UserBean userBean) {
        loginBiz.doLogin(userBean, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iLoginView.loginSuccess((UserBean)result);
            }

            @Override
            public void onFailed(Object msg) {
                iLoginView.loginFailed();
            }
        });
    }

}
