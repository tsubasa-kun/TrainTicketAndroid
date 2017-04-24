package com.wyt.trainticket.view.interfaces;

/**
 * Created by Cookie on 2017/4/24.
 * <p>
 * description：添加联系人View
 */

public interface IAddMemberView {
    /**
     * 添加
     */
    void doAdd();

    /**
     * 添加成功
     */
    void addSuccess();

    /**
     * 添加失败
     * @param msg
     */
    void addFailed(String msg);
}
