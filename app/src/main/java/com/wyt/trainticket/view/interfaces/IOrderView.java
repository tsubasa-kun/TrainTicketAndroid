package com.wyt.trainticket.view.interfaces;

import com.wyt.trainticket.model.bean.OrderBean;

import java.util.List;

/**
 * Created by Cookie on 2017/4/2.
 * <p>
 * description：订单View接口
 */

public interface IOrderView {
    /**
     * 获取订单
     * @param offset
     */
    void getOrder(int offset);

    /**
     * 设置订单列表
     * @param orders
     */
    void setOrderList(List<OrderBean> orders);

    /**
     * 查询失败
     * @param msg
     */
    void queryFailed(String msg);
}
