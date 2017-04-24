package com.wyt.trainticket.presenter;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.biz.AddMemberBiz;
import com.wyt.trainticket.view.interfaces.IAddMemberView;

/**
 * Created by Cookie on 2017/4/24.
 * <p>
 * description：添加联系人Presenter
 */

public class AddMemberPresenter {

    private AddMemberBiz addMemberBiz;
    private IAddMemberView iAddMemberView;

    public AddMemberPresenter(IAddMemberView iAddMemberView) {
        addMemberBiz = new AddMemberBiz();
        this.iAddMemberView = iAddMemberView;
    }

    public void doAdd(String realName, String idNumber) {
        addMemberBiz.doAdd(realName, idNumber, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iAddMemberView.addSuccess();
            }

            @Override
            public void onFailed(Object msg) {
                iAddMemberView.addFailed((String)msg);
            }
        });
    }
}
