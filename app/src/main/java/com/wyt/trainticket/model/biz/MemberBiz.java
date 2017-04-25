package com.wyt.trainticket.model.biz;

import com.google.gson.Gson;
import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.app.TrainTicketApplication;
import com.wyt.trainticket.config.AppConfig;
import com.wyt.trainticket.model.bean.MemberListBean;
import com.wyt.trainticket.model.bean.OrderListBean;
import com.wyt.trainticket.model.biz.interfaces.IMemberBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Cookie on 2017/4/21.
 * <p>
 * description：联系人逻辑
 */

public class MemberBiz implements IMemberBiz {

    /**
     * 查询联系人
     * @param callBack
     */
    @Override
    public void doQuery(final CallBack callBack) {
        //设置请求参数
        RequestParams requestParams = new RequestParams(AppConfig.QUERY_MEMBER);
        requestParams.addParameter("userId", TrainTicketApplication.getUser().getUserId());
        //发送请求
        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                MemberListBean memberListBean = gson.fromJson(result, MemberListBean.class);
                if (memberListBean.getResStatus().equals("success")) {
                    callBack.onSuccess(memberListBean.getMembers());
                } else {
                    callBack.onFailed(memberListBean.getResMsg());
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
