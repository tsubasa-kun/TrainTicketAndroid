package com.wyt.trainticket.model.biz.interfaces;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.MemberBean;

/**
 * Created by Cookie on 2017/4/24.
 * <p>
 * description：编辑联系人逻辑接口
 */

public interface IModifyMemberBiz {
    /**
     * 编辑
     * @param memberBean
     * @param callBack
     */
    void doModify(MemberBean memberBean, CallBack callBack);

    /**
     * 删除
     * @param memberBean
     * @param callBack
     */
    void doDelete(MemberBean memberBean, CallBack callBack);
}
