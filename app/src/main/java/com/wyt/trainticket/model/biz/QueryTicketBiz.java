package com.wyt.trainticket.model.biz;

import com.google.gson.Gson;
import com.love_cookies.cookie_library.interfaces.CallBack;
import com.wyt.trainticket.config.AppConfig;
import com.wyt.trainticket.model.bean.TicketBean;
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
        RequestParams requestParams = new RequestParams(AppConfig.API_URL);
        requestParams.addQueryStringParameter(AppConfig.DATE, date);
        requestParams.addQueryStringParameter(AppConfig.FROM, from);
        requestParams.addQueryStringParameter(AppConfig.TO, to);
        requestParams.addQueryStringParameter(AppConfig.TYPE, type);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                TicketBean ticketBean = gson.fromJson(result, TicketBean.class);
                callBack.onSuccess(filterModel(ticketBean, model));
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
    public TicketBean filterModel(TicketBean data, int model) {
        TicketBean ticketBean = new TicketBean();
        List<TicketBean.DataEntity> dataEntities = new ArrayList<>();
        switch (model) {
            default:
            case AppConfig.MODEL_ALL:
                ticketBean = data;
                break;
            case AppConfig.MODEL_GDC:
                //根据关键字筛选
                for (TicketBean.DataEntity entity : data.getData()) {
                    if (entity.getQueryLeftNewDTO().getStation_train_code().contains("G") ||
                            entity.getQueryLeftNewDTO().getStation_train_code().contains("D") ||
                            entity.getQueryLeftNewDTO().getStation_train_code().contains("C")) {
                        dataEntities.add(entity);
                    }
                }
                ticketBean.setData(dataEntities);
                break;
            case AppConfig.MODEL_Z:
                //根据关键字筛选
                for (TicketBean.DataEntity entity : data.getData()) {
                    if (entity.getQueryLeftNewDTO().getStation_train_code().contains("Z")) {
                        dataEntities.add(entity);
                    }
                }
                ticketBean.setData(dataEntities);
                break;
            case AppConfig.MODEL_T:
                //根据关键字筛选
                for (TicketBean.DataEntity entity : data.getData()) {
                    if (entity.getQueryLeftNewDTO().getStation_train_code().contains("T")) {
                        dataEntities.add(entity);
                    }
                }
                ticketBean.setData(dataEntities);
                break;
            case AppConfig.MODEL_K:
                //根据关键字筛选
                for (TicketBean.DataEntity entity : data.getData()) {
                    if (entity.getQueryLeftNewDTO().getStation_train_code().contains("K")) {
                        dataEntities.add(entity);
                    }
                }
                ticketBean.setData(dataEntities);
                break;
            case AppConfig.MODEL_OTHER:
                //根据关键字筛选
                for (TicketBean.DataEntity entity : data.getData()) {
                    if (!entity.getQueryLeftNewDTO().getStation_train_code().contains("G") &&
                            !entity.getQueryLeftNewDTO().getStation_train_code().contains("D") &&
                            !entity.getQueryLeftNewDTO().getStation_train_code().contains("C") &&
                            !entity.getQueryLeftNewDTO().getStation_train_code().contains("Z") &&
                            !entity.getQueryLeftNewDTO().getStation_train_code().contains("T") &&
                            !entity.getQueryLeftNewDTO().getStation_train_code().contains("K")) {
                        dataEntities.add(entity);
                    }
                }
                ticketBean.setData(dataEntities);
                break;
        }
        return ticketBean;
    }

}
