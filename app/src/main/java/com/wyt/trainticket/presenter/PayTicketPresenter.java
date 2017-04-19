package com.wyt.trainticket.presenter;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.OrderBean;
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
     * @param orderBean
     */
    public void doSubmit(OrderBean orderBean) {
        payTicketBiz.doSubmit(orderBean, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iPayTicketView.paySuccess((OrderBean)result);
            }

            @Override
            public void onFailed(Object msg) {
                iPayTicketView.payFailed((String)msg);
            }
        });
    }
}
