package com.wyt.trainticket.model.biz.interfaces;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.MemberListBean;
import com.wyt.trainticket.model.bean.OrderBean;

/**
 * Created by cookie on 2017/3/21 0021.
 * <p>
 * 车票详情逻辑接口
 */
public interface ITicketDetailBiz {
    /**
     * 提交
     *
     * @param orderBean
     * @param callBack   回调
     */
    void doSubmit(OrderBean orderBean, MemberListBean memberListBean, CallBack callBack);
}
