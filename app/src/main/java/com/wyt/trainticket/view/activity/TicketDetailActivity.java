package com.wyt.trainticket.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.love_cookies.cookie_library.utils.ProgressDialogUtils;
import com.love_cookies.cookie_library.utils.ToastUtils;
import com.wyt.trainticket.R;
import com.wyt.trainticket.config.AppConfig;
import com.wyt.trainticket.model.bean.OrderBean;
import com.wyt.trainticket.model.bean.TicketBean;
import com.wyt.trainticket.presenter.TicketDetailPresenter;
import com.wyt.trainticket.view.interfaces.ITicketDetailView;
import com.wyt.trainticket.view.widget.RadioGroupEx;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.Random;

/**
 * Created by cookie on 2017/3/20 0020.
 * <p>
 * 车票详情页
 */
@ContentView(R.layout.activity_ticket_detail)
public class TicketDetailActivity extends BaseActivity implements ITicketDetailView {

    private String startDate;
    private TicketBean.DataEntity.QueryLeftNewDTOEntity ticketInfo;
    private String seat = AppConfig.SWZ;//席别
    private int money;//票价
    private int carriage;//车厢
    private int seatNo;//座位号
    private TicketDetailPresenter ticketDetailPresenter = new TicketDetailPresenter(this);

    @ViewInject(R.id.title_tv)
    private TextView titleTv;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.start_station_tv)
    private TextView startStationTv;
    @ViewInject(R.id.start_time_tv)
    private TextView startTimeTv;
    @ViewInject(R.id.train_no_tv)
    private TextView trainNoTv;
    @ViewInject(R.id.take_time_tv)
    private TextView takeTimeTv;
    @ViewInject(R.id.end_station_tv)
    private TextView endStationTv;
    @ViewInject(R.id.end_time_tv)
    private TextView endTimeTv;
    @ViewInject(R.id.swz_rb)
    private RadioButton swzRb;
    @ViewInject(R.id.zy_rb)
    private RadioButton zyRb;
    @ViewInject(R.id.ze_rb)
    private RadioButton zeRb;
    @ViewInject(R.id.yz_rb)
    private RadioButton yzRb;
    @ViewInject(R.id.yw_rb)
    private RadioButton ywRb;
    @ViewInject(R.id.wz_rb)
    private RadioButton wzRb;
    @ViewInject(R.id.submit_btn)
    private TextView submitBtn;
    @ViewInject(R.id.seat_rb)
    private RadioGroupEx seatRb;

    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        //获取前面页面传递过来的参数
        startDate = getIntent().getStringExtra("startDate");
        ticketInfo = getIntent().getParcelableExtra("ticket_info");
        //随机生成票价，车厢和座位号
        Random random = new Random();
        money = random.nextInt(500) + 50;
        carriage = random.nextInt(16) + 1;
        seatNo = random.nextInt(100) + 1;
        //设置Title
        titleTv.setText(startDate);
        //设置Title左按钮
        leftBtn.setImageResource(R.drawable.ic_keyboard_backspace_white);
        //设置车票信息
        startStationTv.setText(ticketInfo.getFrom_station_name());
        startTimeTv.setText(ticketInfo.getStart_time());
        trainNoTv.setText(ticketInfo.getStation_train_code());
        takeTimeTv.setText(ticketInfo.getLishi());
        endStationTv.setText(ticketInfo.getTo_station_name());
        endTimeTv.setText(ticketInfo.getArrive_time());
        swzRb.setText(String.format(getResources().getString(R.string.swz_num_text), ticketInfo.getSwz_num()));
        zyRb.setText(String.format(getResources().getString(R.string.zy_num_text), ticketInfo.getZy_num()));
        zeRb.setText(String.format(getResources().getString(R.string.ze_num_text), ticketInfo.getZe_num()));
        yzRb.setText(String.format(getResources().getString(R.string.yz_num_text), ticketInfo.getYz_num()));
        ywRb.setText(String.format(getResources().getString(R.string.yw_num_text), ticketInfo.getYw_num()));
        wzRb.setText(String.format(getResources().getString(R.string.wz_num_text), ticketInfo.getWz_num()));
        //添加按钮点击事件
        leftBtn.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
        seatRb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getCheckedRadioButtonId()) {
                    default:
                    case R.id.swz_rb:
                        seat = AppConfig.SWZ;
                        break;
                    case R.id.zy_rb:
                        seat = AppConfig.YDZ;
                        break;
                    case R.id.ze_rb:
                        seat = AppConfig.EDZ;
                        break;
                    case R.id.yz_rb:
                        seat = AppConfig.YZ;
                        break;
                    case R.id.yw_rb:
                        seat = AppConfig.YW;
                        break;
                    case R.id.wz_rb:
                        seat = AppConfig.WZ;
                        break;
                }
            }
        });
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
            case R.id.submit_btn:
                readyToBuy();
                break;
            default:
                break;
        }
    }

    /**
     * 准备购买
     */
    public void readyToBuy() {
        OrderBean orderBean = new OrderBean();
        orderBean.setTrainNo(ticketInfo.getStation_train_code());
        orderBean.setFrom(ticketInfo.getFrom_station_name());
        orderBean.setStartTime(ticketInfo.getStart_time());
        orderBean.setTo(ticketInfo.getTo_station_name());
        orderBean.setEndTime(ticketInfo.getArrive_time());
        orderBean.setDate(startDate);
        orderBean.setSeat(seat);
        orderBean.setCarriage(carriage + "");
        orderBean.setSeatNo(seatNo + "");
        orderBean.setMoney(money + "");
        doSubmit(orderBean);
    }

    /**
     * 提交
     *
     * @param orderBean
     */
    @Override
    public void doSubmit(OrderBean orderBean) {
        ProgressDialogUtils.showProgress(this);
        ticketDetailPresenter.doSubmit(orderBean);
    }

    /**
     * 支付成功
     *
     * @param orderBean
     */
    @Override
    public void paySuccess(OrderBean orderBean) {
        ProgressDialogUtils.hideProgress();
        Bundle bundle = new Bundle();
        bundle.putParcelable("order", orderBean);
        turnThenFinish(OutTicketActivity.class, bundle);
    }

    /**
     * 支付失败
     */
    @Override
    public void payFailed() {
        ProgressDialogUtils.hideProgress();
        ToastUtils.show(this, R.string.pay_failed_text);
    }
}
