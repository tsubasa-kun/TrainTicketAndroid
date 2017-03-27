package com.wyt.trainticket.model.biz.interfaces;

import com.love_cookies.cookie_library.interfaces.CallBack;

/**
 * Created by cookie on 2017/3/17 0017.
 * <p>
 * 车票查询逻辑接口
 */
public interface IQueryTicketBiz {
    /**
     * 查询车票
     *
     * @param from     出发地
     * @param to       目的地
     * @param date     日期
     * @param type     学生票
     * @param model    车次
     * @param callBack 回调
     */
    void doQuery(String from, String to, String date, String type, int model, CallBack callBack);
}
