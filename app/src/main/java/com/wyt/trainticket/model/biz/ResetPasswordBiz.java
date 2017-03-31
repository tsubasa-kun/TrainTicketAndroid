package com.wyt.trainticket.model.biz;

import com.google.gson.Gson;
import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.config.AppConfig;
import com.wyt.trainticket.model.bean.UserBean;
import com.wyt.trainticket.model.biz.interfaces.IResetPasswordBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Cookie on 2017/3/30.
 * <p>
 * description：修改密码逻辑
 */

public class ResetPasswordBiz implements IResetPasswordBiz {
    /**
     * 修改密码
     * @param userBean
     * @param newPassword
     * @param callBack
     */
    @Override
    public void doReset(UserBean userBean, String newPassword, final CallBack callBack) {
        //组装请求参数
        RequestParams requestParams = new RequestParams(AppConfig.RESET_PASSWORD);
        requestParams.addParameter("account", userBean.getAccount());
        requestParams.addParameter("oldPassword", userBean.getPassword());
        requestParams.addParameter("newPassword", newPassword);
        //发送请求
        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                UserBean userBean = gson.fromJson(result, UserBean.class);
                if (userBean.getResStatus().equals("success")) {
                    callBack.onSuccess(userBean);
                } else {
                    callBack.onFailed(userBean.getResMsg());
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callBack.onFailed(ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }
}
