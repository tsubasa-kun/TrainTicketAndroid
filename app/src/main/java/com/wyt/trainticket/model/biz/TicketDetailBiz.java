package com.wyt.trainticket.model.biz;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.OrderBean;
import com.wyt.trainticket.model.biz.interfaces.ITicketDetailBiz;

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
    public void doSubmit(OrderBean orderBean, CallBack callBack) {
        long timestamp = System.currentTimeMillis();
        orderBean.setOrderId(timestamp + "");
        callBack.onSuccess(orderBean);
    }
}
