package com.wyt.trainticket.model.biz;

import com.google.gson.Gson;
import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.config.AppConfig;
import com.wyt.trainticket.model.bean.OrderListBean;
import com.wyt.trainticket.model.biz.interfaces.IOrderBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import static com.wyt.trainticket.config.AppConfig.QUERY_ORDER;

/**
 * Created by Cookie on 2017/4/2.
 * <p>
 * description：查询订单逻辑
 */

public class OrderBiz implements IOrderBiz {

    /**
     * 查询订单
     * @param account
     * @param offset
     * @param type
     * @param callBack
     */
    @Override
    public void doQuery(String account, int offset, int type, final CallBack callBack) {
        //获取时间戳
        String timestamp = System.currentTimeMillis() + "";
        //设置请求参数
        RequestParams requestParams = new RequestParams(AppConfig.QUERY_ORDER);
        requestParams.addParameter("account", account);
        requestParams.addParameter("offset", offset);
        requestParams.addParameter("timestamp", timestamp);
        requestParams.addParameter("type", type);
        //发送请求
        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                OrderListBean orderListBean = gson.fromJson(result, OrderListBean.class);
                if (orderListBean.getResStatus().equals("success")) {
                    callBack.onSuccess(orderListBean.getOrders());
                } else {
                    callBack.onFailed(orderListBean.getResMsg());
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
