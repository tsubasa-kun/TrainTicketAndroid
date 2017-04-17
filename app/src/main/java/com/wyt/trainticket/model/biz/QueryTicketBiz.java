package com.wyt.trainticket.model.biz;

import com.google.gson.Gson;
import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.config.AppConfig;
import com.wyt.trainticket.model.bean.TicketBean;
import com.wyt.trainticket.model.bean.TicketListBean;
import com.wyt.trainticket.model.biz.interfaces.IQueryTicketBiz;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cookie on 2017/3/17 0017.
 * <p>
 * 查询车票逻辑
 */
public class QueryTicketBiz implements IQueryTicketBiz {
    /**
     * 查询车票
     *
     * @param from     出发地
     * @param to       目的地
     * @param date     日期
     * @param type     学生票
     * @param model    车次
     * @param callBack 回调
     */
    @Override
    public void doQuery(String from, String to, String date, String type, final int model, final CallBack callBack) {
        RequestParams requestParams = new RequestParams(AppConfig.QUERY_TICKET);
        requestParams.addParameter(AppConfig.DATE, date);
        requestParams.addParameter("startStationName", from);
        requestParams.addParameter("toStationName", to);
        requestParams.addParameter(AppConfig.TYPE, type);
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                TicketListBean ticketListBean = gson.fromJson(result, TicketListBean.class);
                callBack.onSuccess(filterModel(ticketListBean, model));
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
        });
    }

    /**
     * 过滤车次类型
     *
     * @param data
     * @return
     */
    public TicketListBean filterModel(TicketListBean data, int model) {
        TicketListBean ticketListBean = new TicketListBean();
        List<TicketBean> ticketList = new ArrayList<>();
        switch (model) {
            default:
            case AppConfig.MODEL_ALL:
                ticketListBean = data;
                break;
            case AppConfig.MODEL_GDC:
                //根据关键字筛选
                for (TicketBean tickets : data.getTickets()) {
                    if (tickets.getTrainCode().contains("G") ||
                            tickets.getTrainCode().contains("D") ||
                            tickets.getTrainCode().contains("C")) {
                        ticketList.add(tickets);
                    }
                }
                ticketListBean.setTickets(ticketList);
                break;
            case AppConfig.MODEL_Z:
                //根据关键字筛选
                for (TicketBean tickets : data.getTickets()) {
                    if (tickets.getTrainCode().contains("Z")) {
                        ticketList.add(tickets);
                    }
                }
                ticketListBean.setTickets(ticketList);
                break;
            case AppConfig.MODEL_T:
                //根据关键字筛选
                for (TicketBean tickets : data.getTickets()) {
                    if (tickets.getTrainCode().contains("T")) {
                        ticketList.add(tickets);
                    }
                }
                ticketListBean.setTickets(ticketList);
                break;
            case AppConfig.MODEL_K:
                //根据关键字筛选
                for (TicketBean tickets : data.getTickets()) {
                    if (tickets.getTrainCode().contains("K")) {
                        ticketList.add(tickets);
                    }
                }
                ticketListBean.setTickets(ticketList);
                break;
            case AppConfig.MODEL_OTHER:
                //根据关键字筛选
                for (TicketBean tickets : data.getTickets()) {
                    if (!tickets.getTrainCode().contains("G") &&
                            !tickets.getTrainCode().contains("D") &&
                            !tickets.getTrainCode().contains("C") &&
                            !tickets.getTrainCode().contains("Z") &&
                            !tickets.getTrainCode().contains("T") &&
                            !tickets.getTrainCode().contains("K")) {
                        ticketList.add(tickets);
                    }
                }
                ticketListBean.setTickets(ticketList);
                break;
        }
        return ticketListBean;
    }

}
