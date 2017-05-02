package com.wyt.trainticket.model.biz.interfaces;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.OrderListBean;

/**
 * Created by Cookie on 2017/4/19.
 * <p>
 * description：支付车票逻辑接口
 */

public interface IPayTicketBiz {
    /**
     * 提交
     *
     * @param orderListBean
     * @param callBack   回调
     */
    void doSubmit(OrderListBean orderListBean, CallBack callBack);
}
