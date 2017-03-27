package com.wyt.trainticket.view.interfaces;

import com.wyt.trainticket.model.bean.TicketBean;

/**
 * Created by cookie on 2017/3/17 0017.
 * <p>
 * 车票查询View接口
 */
public interface IQueryTicketView {
    /**
     * 车票查询
     *
     * @param from  出发地
     * @param to    目的地
     * @param date  日期
     * @param type  学生票
     * @param model 车别
     */
    void doQuery(String from, String to, String date, String type, int model);

    /**
     * 查询成功
     */
    void querySuccess(TicketBean ticketBean);

    /**
     * 查询失败
     */
    void queryFailed();
}
