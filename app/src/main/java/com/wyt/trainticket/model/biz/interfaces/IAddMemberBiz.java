package com.wyt.trainticket.model.biz.interfaces;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.MemberBean;

/**
 * Created by Cookie on 2017/4/24.
 * <p>
 * description：添加联系人逻辑接口
 */

public interface IAddMemberBiz {
    /**
     * 添加
     * @param memberBean
     * @param callBack
     */
    void doAdd(MemberBean memberBean, CallBack callBack);
}
