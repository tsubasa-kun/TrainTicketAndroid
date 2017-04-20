package com.wyt.trainticket.model.biz.interfaces;

import com.love_cookies.cookie_library.interfaces.CallBack;

/**
 * Created by Cookie on 2017/4/21.
 * <p>
 * description：联系人逻辑接口
 */

public interface IMemberBiz {
    /**
     * 查询联系人
     * @param userId
     * @param callBack
     */
    void doQuery(String userId, CallBack callBack);
}
