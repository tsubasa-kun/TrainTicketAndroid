package com.wyt.trainticket.model.biz;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.UserBean;
import com.wyt.trainticket.model.biz.interfaces.IRegisterBiz;

/**
 * Created by Cookie on 2017/3/27.
 * <p>
 * description：注册逻辑
 */

public class RegisterBiz implements IRegisterBiz {

    /**
     * 注册
     * @param userBean 用户实体类
     * @param callBack 回调
     */
    @Override
    public void doRegister(UserBean userBean, CallBack callBack) {
        String account = userBean.getAccount();
        String password = userBean.getPassword();
        String realName = userBean.getRealName();
        String idNumber = userBean.getRealName();
        callBack.onSuccess(userBean);
    }
}
