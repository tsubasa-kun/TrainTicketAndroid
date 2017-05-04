package com.wyt.trainticket.model.biz.interfaces;

import com.love_cookies.cookie_library.interfaces.CallBack;

/**
 * Created by Cookie on 2017/5/4.
 * <p>
 * description：退票逻辑接口
 */

public interface ITuiTicketBiz {
    /**
     * 退票
     * @param id
     * @param callBack
     */
    void doTuiTicket(int id, CallBack callBack);
}
