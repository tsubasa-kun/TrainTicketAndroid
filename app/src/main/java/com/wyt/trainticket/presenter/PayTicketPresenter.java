package com.wyt.trainticket.presenter;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.OrderBean;
import com.wyt.trainticket.model.bean.OrderListBean;
import com.wyt.trainticket.model.biz.PayTicketBiz;
import com.wyt.trainticket.view.interfaces.IPayTicketView;

/**
 * Created by Cookie on 2017/4/19.
 * <p>
 * description：支付车票Presenter
 */

public class PayTicketPresenter {
    private PayTicketBiz payTicketBiz;
    private IPayTicketView iPayTicketView;

    public PayTicketPresenter(IPayTicketView iPayTicketView) {
        payTicketBiz = new PayTicketBiz();
        this.iPayTicketView = iPayTicketView;
    }

    /**
     * 提交
     * @param orderListBean
     */
    public void doSubmit(OrderListBean orderListBean) {
        payTicketBiz.doSubmit(orderListBean, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iPayTicketView.paySuccess((OrderListBean)result);
            }

            @Override
            public void onFailed(Object msg) {
                iPayTicketView.payFailed((String)msg);
            }
        });
    }
}
