package com.wyt.trainticket.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.wyt.trainticket.R;
import com.wyt.trainticket.config.AppConfig;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by cookie on 2017/3/21 0021.
 * <p>
 * 订单页
 */
@ContentView(R.layout.activity_order)
public class OrderActivity extends BaseActivity {

    private int ORDER_STATUS;

    @ViewInject(R.id.title_tv)
    private TextView titleTv;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;

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

    public void setTitle() {
        switch (ORDER_STATUS) {
            default:
            case AppConfig.ORDER_NOW:
                titleTv.setText(R.string.order_now);
                break;
            case AppConfig.ORDER_OLD:
                titleTv.setText(R.string.order_old);
                break;
        }
    }
}
