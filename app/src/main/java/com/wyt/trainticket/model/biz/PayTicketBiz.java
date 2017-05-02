package com.wyt.trainticket.model.biz;

import com.google.gson.Gson;
import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.config.AppConfig;
import com.wyt.trainticket.model.bean.OrderBean;
import com.wyt.trainticket.model.bean.OrderListBean;
import com.wyt.trainticket.model.bean.ResultBean;
import com.wyt.trainticket.model.biz.interfaces.IPayTicketBiz;
import com.wyt.trainticket.utils.DateTimeUtils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Cookie on 2017/4/19.
 * <p>
 * description：支付车票逻辑
 */

public class PayTicketBiz implements IPayTicketBiz {

    Gson gson = new Gson();

    /**
     * 提交
     *
     * @param orderListBean
     * @param callBack   回调
     */
    @Override
    public void doSubmit(final OrderListBean orderListBean, final CallBack callBack) {
        //组装请求参数
        RequestParams requestParams = new RequestParams(AppConfig.PAY_TICKET);
        requestParams.addParameter("orders", gson.toJson(orderListBean));
        //发送请求
        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                ResultBean resultBean = gson.fromJson(result, ResultBean.class);
                if (resultBean.getResStatus().equals("success")) {
                    callBack.onSuccess(orderListBean);
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
