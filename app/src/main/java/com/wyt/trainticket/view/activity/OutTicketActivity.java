package com.wyt.trainticket.view.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.wyt.trainticket.R;
import com.wyt.trainticket.model.bean.OrderBean;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by cookie on 2017/3/21 0021.
 * <p>
 * 出票页
 */
@ContentView(R.layout.activity_out_ticket)
public class OutTicketActivity extends BaseActivity {

    @ViewInject(R.id.title_tv)
    private TextView titleTv;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.ticket_info)
    private LinearLayout ticketInfo;
    @ViewInject(R.id.data_tv)
    private TextView dataTv;
    @ViewInject(R.id.start_time_tv)
    private TextView startTimeTv;
    @ViewInject(R.id.from_tv)
    private TextView fromTv;
    @ViewInject(R.id.end_tv)
    private TextView endTv;
    @ViewInject(R.id.carriage_tv)
    private TextView carriageTv;
    @ViewInject(R.id.seat_no_tv)
    private TextView seatNoTv;
    @ViewInject(R.id.seat_tv)
    private TextView seatTv;
    @ViewInject(R.id.money_tv)
    private TextView moneyTv;
    @ViewInject(R.id.order_id_tv)
    private TextView orderIdTv;

    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        //设置Title
        titleTv.setText(R.string.tip);
        //设置Title左按钮
        leftBtn.setImageResource(R.drawable.ic_keyboard_backspace_white);
        //添加按钮点击事件
        leftBtn.setOnClickListener(this);
        //获取前一个页面传过来的数据
        OrderBean orderBean = getIntent().getParcelableExtra("order");
        //为每个字段设置值
        dataTv.setText(orderBean.getDate());
        startTimeTv.setText(orderBean.getStartTime());
        fromTv.setText(orderBean.getFrom());
        endTv.setText(orderBean.getTo());
        carriageTv.setText(orderBean.getCarriage());
        seatNoTv.setText(orderBean.getSeatNo());
        seatTv.setText(orderBean.getSeat());
        moneyTv.setText(orderBean.getMoney());
        orderIdTv.setText(orderBean.getOrderId());
        //开始出票动画
        startAnimation();
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
     * 开始出票动画
     */
    public void startAnimation() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.slide_down_in);
        anim.setDuration(1000);
        anim.setFillAfter(true);
        ticketInfo.startAnimation(anim);
    }
}
