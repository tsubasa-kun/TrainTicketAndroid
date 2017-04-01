package com.wyt.trainticket.presenter;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.OrderBean;
import com.wyt.trainticket.model.biz.TicketDetailBiz;
import com.wyt.trainticket.view.interfaces.ITicketDetailView;

/**
 * Created by jk on 2017/3/21 0021.
 *
 * 车票详情presenter
 */
public class TicketDetailPresenter {

    private TicketDetailBiz ticketDetailBiz;
    private ITicketDetailView iTicketDetailView;

    public TicketDetailPresenter(ITicketDetailView iTicketDetailView) {
        ticketDetailBiz = new TicketDetailBiz();
        this.iTicketDetailView = iTicketDetailView;
    }

    /**
     * 提交
     *
     * @param orderBean
     */
    public void doSubmit(OrderBean orderBean) {
        ticketDetailBiz.doSubmit(orderBean, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iTicketDetailView.paySuccess((OrderBean)result);
            }

            @Override
            public void onFailed(Object msg) {
                iTicketDetailView.payFailed((String)msg);
            }
        });
    }
}
