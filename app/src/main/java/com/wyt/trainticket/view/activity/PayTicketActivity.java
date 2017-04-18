package com.wyt.trainticket.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.love_cookies.cookie_library.utils.ProgressDialogUtils;
import com.wyt.trainticket.R;
import com.wyt.trainticket.model.bean.OrderBean;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by cookie on 2017/4/18 0018.
 * <p>
 * 车票支付页
 */
@ContentView(R.layout.activity_pay_ticket)
public class PayTicketActivity extends BaseActivity {

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
        //获取前一个页面传过来的数据
        OrderBean orderBean = getIntent().getParcelableExtra("order");
        ProgressDialogUtils.hideProgress();
        Bundle bundle = new Bundle();
        bundle.putParcelable("order", orderBean);
//        turnThenFinish(OutTicketActivity.class, bundle);
        //设置Title
        titleTv.setText(R.string.pay_ticket);
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
}
