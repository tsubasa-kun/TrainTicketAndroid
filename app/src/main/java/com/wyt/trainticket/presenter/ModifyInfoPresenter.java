package com.wyt.trainticket.presenter;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.UserBean;
import com.wyt.trainticket.model.biz.ModifyInfoBiz;
import com.wyt.trainticket.view.interfaces.IModifyInfoView;

/**
 * Created by Cookie on 2017/3/28.
 * <p>
 * description：修改信息Presenter
 */

public class ModifyInfoPresenter {
    private ModifyInfoBiz modifyInfoBiz;
    private IModifyInfoView iModifyInfoView;

    public ModifyInfoPresenter(IModifyInfoView iModifyInfoView) {
        modifyInfoBiz = new ModifyInfoBiz();
        this.iModifyInfoView = iModifyInfoView;
    }

    /**
     * 修改信息
     * @param userBean
     */
    public void doModify(UserBean userBean) {
        modifyInfoBiz.doModify(userBean, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iModifyInfoView.modifySuccess((UserBean)result);
            }

            @Override
            public void onFailed(Object msg) {
                iModifyInfoView.modifyFailed((String)msg);
            }
        });
    }
}
