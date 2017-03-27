package com.wyt.trainticket.presenter;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.UserBean;
import com.wyt.trainticket.model.biz.RegisterBiz;
import com.wyt.trainticket.view.interfaces.IRegisterView;

/**
 * Created by Cookie on 2017/3/27.
 * <p>
 * description：注册Presenter
 */

public class RegisterPersenter {

    private RegisterBiz registerBiz;
    private IRegisterView iRegisterView;

    public RegisterPersenter(IRegisterView iRegisterView) {
        registerBiz = new RegisterBiz();
        this.iRegisterView = iRegisterView;
    }

    /**
     * 注册
     *
     * @param userBean
     */
    public void doRegister(UserBean userBean) {
        registerBiz.doRegister(userBean, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iRegisterView.registerSuccess();
            }

            @Override
            public void onFailed(Object msg) {
                iRegisterView.registerFailed();
            }
        });
    }
}
