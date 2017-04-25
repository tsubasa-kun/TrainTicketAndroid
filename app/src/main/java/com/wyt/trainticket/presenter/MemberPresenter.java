package com.wyt.trainticket.presenter;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.MemberBean;
import com.wyt.trainticket.model.biz.MemberBiz;
import com.wyt.trainticket.view.interfaces.IMemberView;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by Cookie on 2017/4/21.
 * <p>
 * description：联系人Presenter
 */

public class MemberPresenter {

    private MemberBiz memberBiz;
    private IMemberView iMemberView;

    public MemberPresenter(IMemberView iMemberView) {
        memberBiz = new MemberBiz();
        this.iMemberView = iMemberView;
    }

    /**
     * 查询联系人
     */
    public void doQuery() {
        memberBiz.doQuery(new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iMemberView.setMemberList((List<MemberBean>)result);
            }

            @Override
            public void onFailed(Object msg) {
                iMemberView.queryFailed((String)msg);
            }
        });
    }
}
