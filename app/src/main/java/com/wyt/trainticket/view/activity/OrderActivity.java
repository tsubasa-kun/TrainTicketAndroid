package com.wyt.trainticket.view.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.love_cookies.cookie_library.adapter.CommonAdapter;
import com.love_cookies.cookie_library.adapter.CommonViewHolder;
import com.love_cookies.cookie_library.utils.ProgressDialogUtils;
import com.love_cookies.cookie_library.utils.ToastUtils;
import com.love_cookies.cookie_library.widget.LoadAndRefreshView;
import com.wyt.trainticket.R;
import com.wyt.trainticket.app.TrainTicketApplication;
import com.wyt.trainticket.config.AppConfig;
import com.wyt.trainticket.model.bean.OrderBean;
import com.wyt.trainticket.presenter.OrderPresenter;
import com.wyt.trainticket.view.interfaces.IOrderView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cookie on 2017/3/21 0021.
 * <p>
 * 订单页
 */
@ContentView(R.layout.activity_order)
public class OrderActivity extends BaseActivity implements IOrderView, LoadAndRefreshView.OnHeaderRefreshListener, LoadAndRefreshView.OnFooterRefreshListener {

    private int ORDER_STATUS;
    private int offset = 0;
    private OrderPresenter orderPresenter = new OrderPresenter(this);
    private List<OrderBean> orderData = new ArrayList<>();
    private OrderAdapter orderAdapter;

    @ViewInject(R.id.title_tv)
    private TextView titleTv;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.load_and_refresh_view)
    private LoadAndRefreshView loadAndRefreshView;
    @ViewInject(R.id.order_list)
    private ListView orderList;

    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        //获取前面页面传递过来的参数
        ORDER_STATUS = getIntent().getIntExtra("order_status", AppConfig.ORDER_NOW);
        //设置Title
        setTitle();
        //设置Title左按钮
        leftBtn.setImageResource(R.drawable.ic_keyboard_backspace_white);
        //添加按钮点击事件
        leftBtn.setOnClickListener(this);
        //添加下拉上拉监听事件
        loadAndRefreshView.setOnHeaderRefreshListener(this);
        loadAndRefreshView.setOnFooterRefreshListener(this);
        //设置订单列表数据
        orderAdapter = new OrderAdapter(this, orderData);
        orderList.setAdapter(orderAdapter);
        //如果是未完成订单，则可以点击支付
        if (ORDER_STATUS == AppConfig.ORDER_UNFINISHED) {
            orderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    OrderBean orderBean = orderData.get(i);
                    ProgressDialogUtils.hideProgress();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("order", orderBean);
                    turn(PayTicketActivity.class, bundle);
                }
            });
        }
        //获取订单列表
        getOrder(offset);
    }

    /**
     * 控件点击事件
     *
     * @param view
     */
    @Override
    public void widgetClick(View view) {
        switch (view.getId()) {
            case R.id.left_btn:
                finish();
                break;
            default:
                break;
        }
    }

    /**
     * 设置标题
     */
    public void setTitle() {
        switch (ORDER_STATUS) {
            default:
            case AppConfig.ORDER_NOW:
                titleTv.setText(R.string.order_now);
                break;
            case AppConfig.ORDER_OLD:
                titleTv.setText(R.string.order_old);
                break;
            case AppConfig.ORDER_UNFINISHED:
                titleTv.setText(R.string.order_unfinished);
                break;
        }
    }

    /**
     * 获取订单
     * @param offset
     */
    @Override
    public void getOrder(int offset) {
        ProgressDialogUtils.showProgress(this);
        orderPresenter.doQuery(TrainTicketApplication.getUser().getAccount(), offset, ORDER_STATUS);
    }

    /**
     * 设置订单列表
     * @param orders
     */
    @Override
    public void setOrderList(List<OrderBean> orders) {
        ProgressDialogUtils.hideProgress();
        if(offset == 0) {
            orderData.clear();
        }
        orderData.addAll(orders);
        orderAdapter.notifyDataSetChanged();
        onComplete();
    }

    /**
     * 查询失败
     * @param msg
     */
    @Override
    public void queryFailed(String msg) {
        ProgressDialogUtils.hideProgress();
        ToastUtils.show(this, msg);
        onComplete();
    }

    /**
     * 下拉刷新
     * @param view
     */
    @Override
    public void onHeaderRefresh(LoadAndRefreshView view) {
        offset = 0;
        getOrder(offset);
    }

    /**
     * 上拉加载
     * @param view
     */
    @Override
    public void onFooterRefresh(LoadAndRefreshView view) {
        getOrder(++offset);
    }

    /**
     * 下拉刷新&上拉加载完成
     */
    public void onComplete() {
        loadAndRefreshView.onHeaderRefreshComplete();
        loadAndRefreshView.onFooterRefreshComplete();
    }

    /**
     * 订单列表适配器
     */
    class OrderAdapter extends CommonAdapter<OrderBean> {

        public OrderAdapter(Context context, List<OrderBean> data) {
            super(context, R.layout.view_order_list_item, data);
        }

        @Override
        public void convert(CommonViewHolder holder, OrderBean orderBean) {
            //设置每项字段值
            holder.setText(R.id.date_tv, orderBean.getDate());
            holder.setText(R.id.start_time_tv, orderBean.getStartTime() + "开");
            holder.setText(R.id.from_station_tv, orderBean.getFromStation());
            holder.setText(R.id.to_station_tv, orderBean.getToStation());
            holder.setText(R.id.train_no_tv, orderBean.getTrainNo());
            holder.setText(R.id.seat_tv, orderBean.getSeat());
            holder.setText(R.id.carriage_tv, orderBean.getCarriage() + "车");
            holder.setText(R.id.seat_no_tv, orderBean.getSeatNo() + "座");
            holder.setText(R.id.real_name_tv, TrainTicketApplication.getUser().getRealName());
            holder.setText(R.id.type_tv, orderBean.getType());
            holder.setText(R.id.money_tv, orderBean.getMoney() + "元");
        }
    }

}
