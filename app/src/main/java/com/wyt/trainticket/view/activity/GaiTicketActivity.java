package com.wyt.trainticket.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.wyt.trainticket.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by cookie on 2017/05/04 0004.
 * <p>
 * 改签页
 */
@ContentView(R.layout.activity_gai_ticket)
public class GaiTicketActivity extends BaseActivity {

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
        //设置Title
        titleTv.setText(R.string.gai_ticket_text);
        //设置Title左按钮
        leftBtn.setImageResource(R.drawable.ic_keyboard_backspace_white);
        //添加按钮点击事件
        leftBtn.setOnClickListener(this);
        //改签把此票的status改成3，orderID改成0
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
