package com.wyt.trainticket.view.interfaces;

import com.wyt.trainticket.model.bean.MemberBean;

import java.util.List;

/**
 * Created by Cookie on 2017/4/21.
 * <p>
 * description：联系人查询View接口
 */

public interface IMemberView {
    /**
     * 查询联系人
     */
    void getMember();

    /**
     * 设置联系人列表
     * @param members
     */
    void setMemberList(List<MemberBean> members);

    /**
     * 查询失败
     * @param msg
     */
    void queryFailed(String msg);
}
