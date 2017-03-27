package com.wyt.trainticket.presenter;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.TicketBean;
import com.wyt.trainticket.model.biz.QueryTicketBiz;
import com.wyt.trainticket.view.interfaces.IQueryTicketView;

/**
 * Created by cookie on 2017/3/17 0017.
 * <p>
 * 车票查询presenter
 */
public class QueryTicketPresenter {

    private QueryTicketBiz queryTicketBiz;
    private IQueryTicketView iQueryTicketView;

    public QueryTicketPresenter(IQueryTicketView iQueryTicketView) {
        queryTicketBiz = new QueryTicketBiz();
        this.iQueryTicketView = iQueryTicketView;
    }

    /**
     * 车票查询
     *
     * @param from  出发地
     * @param to    目的地
     * @param date  日期
     * @param type  学生票
     * @param model 车别
     */
    public void doQuery(String from, String to, String date, String type, int model) {
        queryTicketBiz.doQuery(from, to, date, type, model, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iQueryTicketView.querySuccess((TicketBean) result);
            }

            @Override
            public void onFailed(Object msg) {
                iQueryTicketView.queryFailed();
            }
        });
    }
}
