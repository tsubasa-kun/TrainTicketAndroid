package com.wyt.trainticket.view.interfaces;

import com.wyt.trainticket.model.bean.OrderListBean;

/**
 * Created by cookie on 2017/3/21 0021.
 * <p>
 * 车票详情View接口
 */
public interface ITicketDetailView {
    /**
     * 提交
     */
    void doSubmit();

    /**
     * 生成订单成功
     *
     * @param orderListBean
     */
    void orderSuccess(OrderListBean orderListBean);

    /**
     * 生成订单失败
     *
     * @param msg
     */
    void orderFailed(String msg);
}
