package com.wyt.trainticket.view.interfaces;

import com.wyt.trainticket.model.bean.MemberBean;

/**
 * Created by Cookie on 2017/4/24.
 * <p>
 * description：编辑联系人View接口
 */

public interface IModifyMemberView {
    /**
     * 修改
     */
    void doModify();

    /**
     * 修改成功
     * @param msg
     */
    void modifySuccess(String msg);

    /**
     * 修改失败
     * @param msg
     */
    void modifyFailed(String msg);

    /**
     * 删除
     */
    void doDelete();

    /**
     * 删除成功
     * @param msg
     */
    void deleteSuccess(String msg);

    /**
     * 删除失败
     * @param msg
     */
    void deleteFailed(String msg);

}
