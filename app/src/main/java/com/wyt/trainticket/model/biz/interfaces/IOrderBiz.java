package com.wyt.trainticket.model.biz.interfaces;

import com.love_cookies.cookie_library.interfaces.CallBack;

/**
 * Created by Cookie on 2017/4/2.
 * <p>
 * description：订单逻辑接口
 */

public interface IOrderBiz {
    /**
     * 查询订单
     * @param account
     * @param offset
     * @param type
     * @param callBack
     */
    void doQuery(String account, int offset, int type, CallBack callBack);
}
