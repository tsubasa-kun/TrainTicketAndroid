package com.wyt.trainticket.presenter;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.biz.TuiTicketBiz;
import com.wyt.trainticket.view.interfaces.ITuiTicketView;

/**
 * Created by Cookie on 2017/5/4.
 * <p>
 * description：退票Presenter
 */

public class TuiTicketPresenter {

    private TuiTicketBiz tuiTicketBiz;
    private ITuiTicketView iTuiTicketView;

    public TuiTicketPresenter(ITuiTicketView iTuiTicketView) {
        tuiTicketBiz = new TuiTicketBiz();
        this.iTuiTicketView = iTuiTicketView;
    }

    /**
     * 退票
     * @param id
     */
    public void doTuiTicket(int id) {
        tuiTicketBiz.doTuiTicket(id, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iTuiTicketView.tuiTicketSuccess();
            }

            @Override
            public void onFailed(Object msg) {
                iTuiTicketView.tuiTicketFailed((String)msg);
            }
        });
    }
}
