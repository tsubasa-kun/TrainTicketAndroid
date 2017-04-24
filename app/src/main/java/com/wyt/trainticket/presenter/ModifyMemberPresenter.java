package com.wyt.trainticket.presenter;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.MemberBean;
import com.wyt.trainticket.model.biz.ModifyMemberBiz;
import com.wyt.trainticket.view.interfaces.IModifyMemberView;

/**
 * Created by Cookie on 2017/4/24.
 * <p>
 * description：编辑联系人Presenter
 */

public class ModifyMemberPresenter {

    private ModifyMemberBiz modifyMemberBiz;
    private IModifyMemberView iModifyMemberView;

    public ModifyMemberPresenter(IModifyMemberView iModifyMemberView) {
        modifyMemberBiz = new ModifyMemberBiz();
        this.iModifyMemberView = iModifyMemberView;
    }

    /**
     * 编辑
     * @param memberBean
     */
    public void doModify(MemberBean memberBean) {
        modifyMemberBiz.doModify(memberBean, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iModifyMemberView.modifySuccess((String)result);
            }

            @Override
            public void onFailed(Object msg) {
                iModifyMemberView.modifyFailed((String)msg);
            }
        });
    }

    /**
     * 删除
     * @param memberBean
     */
    public void doDelete(MemberBean memberBean) {
        modifyMemberBiz.doDelete(memberBean, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iModifyMemberView.deleteSuccess((String)result);
            }

            @Override
            public void onFailed(Object msg) {
                iModifyMemberView.deleteFailed((String)msg);
            }
        });
    }
}
