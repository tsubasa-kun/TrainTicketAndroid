package com.wyt.trainticket.model.biz;

import com.google.gson.Gson;
import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.config.AppConfig;
import com.wyt.trainticket.model.bean.MemberBean;
import com.wyt.trainticket.model.bean.ResultBean;
import com.wyt.trainticket.model.biz.interfaces.IModifyMemberBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Cookie on 2017/4/24.
 * <p>
 * description：编辑联系人逻辑
 */

public class ModifyMemberBiz implements IModifyMemberBiz {

    /**
     * 编辑
     * @param memberBean
     * @param callBack
     */
    @Override
    public void doModify(MemberBean memberBean,final CallBack callBack) {
        //组装请求参数
        RequestParams requestParams = new RequestParams(AppConfig.MODIFY_MEMBER);
        requestParams.addParameter("id", memberBean.getId());
        requestParams.addParameter("realName", memberBean.getMemberRealName());
        requestParams.addParameter("idNumber", memberBean.getMemberIdNumber());
        //发送请求
        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ResultBean resultBean = gson.fromJson(result, ResultBean.class);
                if (resultBean.getResStatus().equals("success")) {
                    callBack.onSuccess(resultBean.getResMsg());
                } else {
                    callBack.onFailed(resultBean.getResMsg());
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callBack.onFailed(ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }

    /**
     * 删除
     * @param memberBean
     * @param callBack
     */
    @Override
    public void doDelete(MemberBean memberBean, final CallBack callBack) {
//组装请求参数
        RequestParams requestParams = new RequestParams(AppConfig.DELETE_MEMBER);
        requestParams.addParameter("id", memberBean.getId());
        //发送请求
        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ResultBean resultBean = gson.fromJson(result, ResultBean.class);
                if (resultBean.getResStatus().equals("success")) {
                    callBack.onSuccess(resultBean.getResMsg());
                } else {
                    callBack.onFailed(resultBean.getResMsg());
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callBack.onFailed(ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }
}
