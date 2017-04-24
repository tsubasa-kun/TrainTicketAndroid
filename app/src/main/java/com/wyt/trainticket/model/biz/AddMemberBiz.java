package com.wyt.trainticket.model.biz;

import com.google.gson.Gson;
import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.app.TrainTicketApplication;
import com.wyt.trainticket.config.AppConfig;
import com.wyt.trainticket.model.bean.ResultBean;
import com.wyt.trainticket.model.biz.interfaces.IAddMemberBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Cookie on 2017/4/24.
 * <p>
 * description：添加联系人逻辑
 */

public class AddMemberBiz implements IAddMemberBiz {
    /**
     * 添加联系人
     * @param realName
     * @param idNumber
     * @param callBack
     */
    @Override
    public void doAdd(String realName, String idNumber, final CallBack callBack) {
        //组装请求参数
        RequestParams requestParams = new RequestParams(AppConfig.ADD_MEMBER);
        requestParams.addParameter("userId", TrainTicketApplication.getUser().getUserId());
        requestParams.addParameter("realName", realName);
        requestParams.addParameter("idNumber", idNumber);
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
