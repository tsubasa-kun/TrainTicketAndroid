package com.wyt.trainticket.model.biz.interfaces;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.UserBean;

/**
 * Created by cookie on 2017/3/27.
 *
 * 注册逻辑接口
 */
public interface IRegisterBiz {
    /**
     * 注册
     * @param userBean 用户实体类
     * @param callBack 回调
     */
    void doRegister(UserBean userBean, CallBack callBack);
}
