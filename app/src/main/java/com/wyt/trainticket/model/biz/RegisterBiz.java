package com.wyt.trainticket.model.biz;

import com.google.gson.Gson;
import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.config.AppConfig;
import com.wyt.trainticket.model.bean.ResultBean;
import com.wyt.trainticket.model.bean.UserBean;
import com.wyt.trainticket.model.biz.interfaces.IRegisterBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Cookie on 2017/3/27.
 * <p>
 * description：注册逻辑
 */

public class RegisterBiz implements IRegisterBiz {

    /**
     * 注册
     * @param userBean 用户实体类
     * @param callBack 回调
     */
    @Override
    public void doRegister(UserBean userBean, final CallBack callBack) {
        //组装请求参数
        RequestParams requestParams = new RequestParams(AppConfig.REGISTER);
        requestParams.addParameter("account", userBean.getAccount());
        requestParams.addParameter("password", userBean.getPassword());
        requestParams.addParameter("realName", userBean.getRealName());
        requestParams.addParameter("idNumber", userBean.getIdNumber());
        //发送请求
        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ResultBean resultBean = gson.fromJson(result, ResultBean.class);
                if (resultBean.getResStatus().equals("success")) {
                    callBack.onSuccess(resultBean.getResMsg());
                } else {
                    callBack.onFailed(resultBean.getResMsg());
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
