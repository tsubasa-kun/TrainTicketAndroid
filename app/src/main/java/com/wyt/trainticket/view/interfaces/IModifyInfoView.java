package com.wyt.trainticket.view.interfaces;

import com.wyt.trainticket.model.bean.UserBean;

/**
 * Created by Cookie on 2017/3/28.
 * <p>
 * description：修改信息View接口
 */

public interface IModifyInfoView {
    /**
     * 修改信息
     */
    void doModify();

    /**
     * 修改成功
     * @param userBean
     */
    void modifySuccess(UserBean userBean);

    /**
     * 修改失败
     * @param msg
     */
    void modifyFailed(String msg);
}
