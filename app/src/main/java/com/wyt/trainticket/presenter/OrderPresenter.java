package com.wyt.trainticket.presenter;

import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.model.bean.OrderBean;
import com.wyt.trainticket.model.biz.OrderBiz;
import com.wyt.trainticket.view.interfaces.IOrderView;

import java.util.List;

/**
 * Created by Cookie on 2017/4/2.
 * <p>
 * description：订单Presenter
 */

public class OrderPresenter {

    private OrderBiz orderBiz;
    private IOrderView iOrderView;

    public OrderPresenter(IOrderView iOrderView) {
        orderBiz = new OrderBiz();
        this.iOrderView = iOrderView;
    }

    /**
     * 查询
     * @param account
     * @param offset
     * @param type
     */
    public void doQuery(String account, int offset, int type) {
        orderBiz.doQuery(account, offset, type, new CallBack() {
            @Override
            public void onSuccess(Object result) {
                iOrderView.setOrderList((List<OrderBean>)result);
            }

            @Override
            public void onFailed(Object msg) {
                iOrderView.queryFailed((String)msg);
            }
        });
    }
}
