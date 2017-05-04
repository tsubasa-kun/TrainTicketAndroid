package com.wyt.trainticket.model.biz;

import com.google.gson.Gson;
import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.config.AppConfig;
import com.wyt.trainticket.model.bean.ResultBean;
import com.wyt.trainticket.model.biz.interfaces.ITuiTicketBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Cookie on 2017/5/4.
 * <p>
 * description：退票逻辑
 */

public class TuiTicketBiz implements ITuiTicketBiz {

    /**
     * 退票
     * @param id
     * @param callBack
     */
    @Override
    public void doTuiTicket(int id, final CallBack callBack) {
//组装请求参数
        RequestParams requestParams = new RequestParams(AppConfig.TUI_TICKET);
        requestParams.addParameter("id", id);
        //发送请求
        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ResultBean resultBean = gson.fromJson(result, ResultBean.class);
                if (resultBean.getResStatus().equals("success")) {
                    callBack.onSuccess(0);
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
