package com.wyt.trainticket.model.biz;

import com.google.gson.Gson;
import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.config.AppConfig;
import com.wyt.trainticket.model.bean.OrderBean;
import com.wyt.trainticket.model.bean.ResultBean;
import com.wyt.trainticket.model.biz.interfaces.ITicketDetailBiz;
import com.wyt.trainticket.utils.DateTimeUtils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by cookie on 2017/3/21 0021.
 * <p>
 * 车票详情逻辑
 */
public class TicketDetailBiz implements ITicketDetailBiz {

    /**
     * 提交
     *
     * @param orderBean
     * @param callBack   回调
     */
    @Override
    public void doSubmit(final OrderBean orderBean, final CallBack callBack) {
        String dateTime = orderBean.getDate() + " " + orderBean.getStartTime();
        String timestamp = DateTimeUtils.getInstance().dataToTimestamp(dateTime);
        orderBean.setOrderId(timestamp);
        //组装请求参数
        RequestParams requestParams = new RequestParams(AppConfig.BUY_TIVKET);
        requestParams.addParameter("orderId", orderBean.getOrderId());
        requestParams.addParameter("account", orderBean.getAccount());
        requestParams.addParameter("trainNo", orderBean.getTrainNo());
        requestParams.addParameter("fromStation", orderBean.getFromStation());
        requestParams.addParameter("startTime", orderBean.getStartTime());
        requestParams.addParameter("toStation", orderBean.getToStation());
        requestParams.addParameter("endTime", orderBean.getEndTime());
        requestParams.addParameter("date", orderBean.getDate());
        requestParams.addParameter("seat", orderBean.getSeat());
        requestParams.addParameter("carriage", orderBean.getCarriage());
        requestParams.addParameter("seatNo", orderBean.getSeatNo());
        requestParams.addParameter("money", orderBean.getMoney());
        //发送请求
        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ResultBean resultBean = gson.fromJson(result, ResultBean.class);
                if (resultBean.getResStatus().equals("success")) {
                    callBack.onSuccess(orderBean);
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
