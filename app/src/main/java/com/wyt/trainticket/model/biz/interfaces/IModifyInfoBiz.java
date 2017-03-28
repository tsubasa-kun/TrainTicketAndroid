package com.wyt.trainticket.model.biz.interfaces;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.UserBean;

/**
 * Created by Cookie on 2017/3/28.
 * <p>
 * description：修改信息逻辑接口
 */

public interface IModifyInfoBiz {
    /**
     * 修改信息
     * @param userBean
     * @param callBack
     */
    void doModify(UserBean userBean, CallBack callBack);
}
