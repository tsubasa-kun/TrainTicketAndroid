package com.wyt.trainticket.model.biz;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.UserBean;
import com.wyt.trainticket.model.biz.interfaces.IModifyInfoBiz;

/**
 * Created by Cookie on 2017/3/28.
 * <p>
 * description：修改信息逻辑
 */

public class ModifyInfoBiz implements IModifyInfoBiz{
    /**
     * 修改信息
     * @param userBean
     * @param callBack
     */
    @Override
    public void doModify(UserBean userBean, CallBack callBack) {
        callBack.onSuccess(userBean);
    }
}
