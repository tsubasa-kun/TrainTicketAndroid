package com.wyt.trainticket.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.love_cookies.cookie_library.fragment.BaseFragment;
import com.wyt.trainticket.R;
import com.wyt.trainticket.config.AppConfig;
import com.wyt.trainticket.utils.DateTimeUtils;
import com.wyt.trainticket.view.activity.OrderActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by cookie on 2017/3/16 0016.
 * <p>
 * 订单
 */
@ContentView(R.layout.fragment_order)
public class OrderFragment extends BaseFragment {

    @ViewInject(R.id.date_tv)
    private TextView dateTv;
    @ViewInject(R.id.unfinished_order_btn)
    private TextView unfinishedOrderBtn;
    @ViewInject(R.id.now_order_btn)
    private TextView nowOrderBtn;
    @ViewInject(R.id.old_order_btn)
    private TextView oldOrderBtn;

    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        //设置日期
        dateTv.setText(DateTimeUtils.getInstance().getCurrentDate());
        //设置按钮点击事件
        unfinishedOrderBtn.setOnClickListener(this);
        nowOrderBtn.setOnClickListener(this);
        oldOrderBtn.setOnClickListener(this);
    }

    /**
     * 控件点击事件
     *
     * @param view
     */
    @Override
    public void widgetClick(View view) {
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.unfinished_order_btn:
                bundle.putInt("order_status", AppConfig.ORDER_UNFINISHED);
                break;
            case R.id.now_order_btn:
                bundle.putInt("order_status", AppConfig.ORDER_NOW);
                break;
            case R.id.old_order_btn:
                bundle.putInt("order_status", AppConfig.ORDER_OLD);
                break;
            default:
                break;
        }
        turn(OrderActivity.class, bundle);
    }
}