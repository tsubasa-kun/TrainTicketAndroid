package com.wyt.trainticket.view.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.love_cookies.cookie_library.utils.ProgressDialogUtils;
import com.love_cookies.cookie_library.utils.ToastUtils;
import com.wyt.trainticket.R;
import com.wyt.trainticket.app.TrainTicketApplication;
import com.wyt.trainticket.event.OrderChangeEvent;
import com.wyt.trainticket.model.bean.OrderBean;
import com.wyt.trainticket.presenter.TuiTicketPresenter;
import com.wyt.trainticket.view.interfaces.ITuiTicketView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import de.greenrobot.event.EventBus;

/**
 * Created by cookie on 2017/05/04 0004.
 * <p>
 * 退票页
 */
@ContentView(R.layout.activity_tui_ticket)
public class TuiTicketActivity extends BaseActivity implements ITuiTicketView {

    private OrderBean orderBean;
    private TuiTicketPresenter tuiTicketPresenter = new TuiTicketPresenter(this);

    @ViewInject(R.id.title_tv)
    private TextView titleTv;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.date_tv)
    private TextView dateTv;
    @ViewInject(R.id.start_time_tv)
    private TextView startTimeTv;
    @ViewInject(R.id.from_station_tv)
    private TextView fromStationTv;
    @ViewInject(R.id.to_station_tv)
    private TextView toStationTv;
    @ViewInject(R.id.train_no_tv)
    private TextView trainNoTv;
    @ViewInject(R.id.seat_tv)
    private TextView seatTv;
    @ViewInject(R.id.carriage_tv)
    private TextView carriageTv;
    @ViewInject(R.id.seat_no_tv)
    private TextView seatNoTv;
    @ViewInject(R.id.real_name_tv)
    private TextView realNameTv;
    @ViewInject(R.id.type_tv)
    private TextView typeTv;
    @ViewInject(R.id.money_tv)
    private TextView moneyTv;
    @ViewInject(R.id.tui_ticket_btn)
    private TextView tuiTicketBtn;

    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        //设置Title
        titleTv.setText(R.string.tui_ticket_text);
        //设置Title左按钮
        leftBtn.setImageResource(R.drawable.ic_keyboard_backspace_white);
        //添加按钮点击事件
        leftBtn.setOnClickListener(this);
        tuiTicketBtn.setOnClickListener(this);
        //接收上个页面传递过来的参数
        orderBean = getIntent().getExtras().getParcelable("order");
        //设置值
        dateTv.setText(orderBean.getDate());
        startTimeTv.setText(orderBean.getStartTime() + "开");
        fromStationTv.setText(orderBean.getFromStation());
        toStationTv.setText(orderBean.getToStation());
        trainNoTv.setText(orderBean.getTrainNo());
        seatTv.setText(orderBean.getSeat());
        carriageTv.setText(orderBean.getCarriage() + "车");
        seatNoTv.setText(orderBean.getSeatNo() + "座");
        realNameTv.setText(orderBean.getRealName());
        typeTv.setText(orderBean.getType());
        moneyTv.setText(orderBean.getMoney() + "元");
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
            case R.id.tui_ticket_btn:
                doTuiTicket();
                break;
            default:
                break;
        }
    }

    /**
     * 退票
     */
    @Override
    public void doTuiTicket() {
        tuiTicketPresenter.doTuiTicket(orderBean.getId());
    }

    /**
     * 退票成功
     */
    @Override
    public void tuiTicketSuccess() {
        ProgressDialogUtils.hideProgress();
        //信息提示
        String message = "退票成功，车票费用：" + orderBean.getMoney() + "将原路退回";
        //弹出确认框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                EventBus.getDefault().post(new OrderChangeEvent());
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    /**
     * 退票失败
     * @param msg
     */
    @Override
    public void tuiTicketFailed(String msg) {
        ProgressDialogUtils.hideProgress();
        ToastUtils.show(this, msg);
    }
}
