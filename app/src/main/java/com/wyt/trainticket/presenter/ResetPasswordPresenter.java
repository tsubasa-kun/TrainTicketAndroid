package com.wyt.trainticket.presenter;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.UserBean;
import com.wyt.trainticket.model.biz.ResetPasswordBiz;
import com.wyt.trainticket.view.interfaces.IResetPasswordView;

/**
 * Created by Cookie on 2017/3/30.
 * <p>
 * description：修改密码Presenter
 */

public class ResetPasswordPresenter {
    private ResetPasswordBiz resetPasswordBiz;
    private IResetPasswordView iResetPasswordView;

    public ResetPasswordPresenter(IResetPasswordView iResetPasswordView) {
        resetPasswordBiz = new ResetPasswordBiz();
        this.iResetPasswordView = iResetPasswordView;
    }

    /**
     * 修改密码
     * @param userBean
     * @param newPassword
     */
    public void doReset(UserBean userBean, String newPassword) {
        resetPasswordBiz.doReset(userBean, newPassword, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iResetPasswordView.resetSuccess((UserBean)result);
            }

            @Override
            public void onFailed(Object msg) {
                iResetPasswordView.resetFailed((String)msg);
            }
        });
    }
}
