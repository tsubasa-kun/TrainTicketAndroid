package com.wyt.trainticket.model.biz.interfaces;

import com.love_cookies.cookie_library.interfaces.CallBack;

/**
 * Created by Cookie on 2017/4/24.
 * <p>
 * description：添加联系人逻辑接口
 */

public interface IAddMemberBiz {
    /**
     * 添加
     * @param realName
     * @param idNumber
     * @param callBack
     */
    void doAdd(String realName, String idNumber, CallBack callBack);
}
