package com.wyt.trainticket.view.interfaces;

import com.wyt.trainticket.model.bean.OrderBean;

/**
 * Created by Cookie on 2017/4/19.
 * <p>
 * description：支付车票View接口
 */

public interface IPayTicketView {
    /**
     * 提交
     */
    void doSubmit();

    /**
     * 支付成功
     *
     * @param orderBean
     */
    void paySuccess(OrderBean orderBean);

    /**
     * 支付失败
     *
     * @param msg
     */
    void payFailed(String msg);
}
