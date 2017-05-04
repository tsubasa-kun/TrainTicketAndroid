package com.wyt.trainticket.view.interfaces;

/**
 * Created by Cookie on 2017/5/4.
 * <p>
 * description：退票确认View接口
 */

public interface ITuiTicketView {
    /**
     * 退票
     */
    void doTuiTicket();

    /**
     * 退票成功
     */
    void tuiTicketSuccess();

    /**
     * 退票失败
     * @param msg
     */
    void tuiTicketFailed(String msg);
}
