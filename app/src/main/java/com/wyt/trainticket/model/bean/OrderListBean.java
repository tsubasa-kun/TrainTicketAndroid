package com.wyt.trainticket.model.bean;

import java.util.List;

/**
 * Created by Cookie on 2017/4/2.
 * <p>
 * description：订单列表实体类
 */

public class OrderListBean extends ResultBean {

    private List<OrderBean> orders;

    public List<OrderBean> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderBean> orders) {
        this.orders = orders;
    }
}
