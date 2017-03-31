package com.wyt.trainticket.model.biz;

import com.google.gson.Gson;
import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.config.AppConfig;
import com.wyt.trainticket.model.bean.UserBean;
import com.wyt.trainticket.model.biz.interfaces.ILoginBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

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
    public void doLogin(UserBean userBean, final CallBack callBack) {
        //组装请求参数
        RequestParams requestParams = new RequestParams(AppConfig.LOGIN);
        requestParams.addParameter("account", userBean.getAccount());
        requestParams.addParameter("password", userBean.getPassword());
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
