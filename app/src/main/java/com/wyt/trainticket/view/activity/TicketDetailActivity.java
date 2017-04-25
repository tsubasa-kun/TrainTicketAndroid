package com.wyt.trainticket.view.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.love_cookies.cookie_library.adapter.CommonAdapter;
import com.love_cookies.cookie_library.adapter.CommonViewHolder;
import com.love_cookies.cookie_library.utils.ProgressDialogUtils;
import com.love_cookies.cookie_library.utils.ToastUtils;
import com.love_cookies.cookie_library.widget.MeasuredListView;
import com.wyt.trainticket.R;
import com.wyt.trainticket.app.TrainTicketApplication;
import com.wyt.trainticket.config.AppConfig;
import com.wyt.trainticket.model.bean.MemberBean;
import com.wyt.trainticket.model.bean.MemberListBean;
import com.wyt.trainticket.model.bean.OrderBean;
import com.wyt.trainticket.model.bean.TicketBean;
import com.wyt.trainticket.presenter.TicketDetailPresenter;
import com.wyt.trainticket.view.interfaces.ITicketDetailView;
import com.wyt.trainticket.view.widget.RadioGroupEx;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.List;
import java.util.Random;

/**
 * Created by cookie on 2017/3/20 0020.
 * <p>
 * 车票详情页
 */
@ContentView(R.layout.activity_ticket_detail)
public class TicketDetailActivity extends BaseActivity implements ITicketDetailView {

    private String startDate;
    private TicketBean ticketInfo;
    private String seat = AppConfig.SWZ;//席别
    private String seatCount = "--";//席别车票数
    private int money;//票价
    private int carriage;//车厢
    private String seatNo;//座位号
    private String type;//车票类型
    private TicketDetailPresenter ticketDetailPresenter = new TicketDetailPresenter(this);
    private int SELECT_MEMBER = 0;
    private MemberListBean memberListBean = new MemberListBean();

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
    @ViewInject(R.id.add_member_btn)
    private LinearLayout addMemberBtn;
    @ViewInject(R.id.member_list)
    private MeasuredListView memberList;

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
        type = getIntent().getStringExtra("type");
        switch (type) {
            default:
            case AppConfig.ADULT:
                type = "成人票";
                break;
            case AppConfig.STUDENT:
                type = "学生票";
                break;
        }
        //随机生成票价，车厢和座位号
        Random random = new Random();
        carriage = random.nextInt(16) + 1;
        seatNo = (random.nextInt(100) + 1) + "";
        //设置Title
        titleTv.setText(startDate);
        //设置Title左按钮
        leftBtn.setImageResource(R.drawable.ic_keyboard_backspace_white);
        //设置车票信息
        startStationTv.setText(ticketInfo.getStartStationName());
        startTimeTv.setText(ticketInfo.getStartTime());
        trainNoTv.setText(ticketInfo.getTrainCode());
        takeTimeTv.setText(ticketInfo.getLishi());
        endStationTv.setText(ticketInfo.getToStationName());
        endTimeTv.setText(ticketInfo.getArriveTime());
        swzRb.setText(String.format(getResources().getString(R.string.swz_num_text), ticketInfo.getSwzNum()));
        zyRb.setText(String.format(getResources().getString(R.string.zy_num_text), ticketInfo.getZyNum()));
        zeRb.setText(String.format(getResources().getString(R.string.ze_num_text), ticketInfo.getZeNum()));
        yzRb.setText(String.format(getResources().getString(R.string.yz_num_text), ticketInfo.getYzNum()));
        ywRb.setText(String.format(getResources().getString(R.string.yw_num_text), ticketInfo.getYwNum()));
        wzRb.setText(String.format(getResources().getString(R.string.wz_num_text), ticketInfo.getWzNum()));
        //默认选中商务座
        seatCount = ticketInfo.getSwzNum();
        money = Integer.parseInt(ticketInfo.getSwzMoney());
        //添加按钮点击事件
        leftBtn.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
        addMemberBtn.setOnClickListener(this);
        seatRb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getCheckedRadioButtonId()) {
                    default:
                    case R.id.swz_rb:
                        seat = AppConfig.SWZ;
                        seatCount = ticketInfo.getSwzNum();
                        money = Integer.parseInt(ticketInfo.getSwzMoney());
                        break;
                    case R.id.zy_rb:
                        seat = AppConfig.YDZ;
                        seatCount = ticketInfo.getZyNum();
                        money = Integer.parseInt(ticketInfo.getZyMoney());
                        break;
                    case R.id.ze_rb:
                        seat = AppConfig.EDZ;
                        seatCount = ticketInfo.getZeNum();
                        money = Integer.parseInt(ticketInfo.getZeMoney());
                        break;
                    case R.id.yz_rb:
                        seat = AppConfig.YZ;
                        seatCount = ticketInfo.getYzNum();
                        money = Integer.parseInt(ticketInfo.getYzMoney());
                        break;
                    case R.id.yw_rb:
                        seat = AppConfig.YW;
                        seatCount = ticketInfo.getYwNum();
                        money = Integer.parseInt(ticketInfo.getYwMoney());
                        break;
                    case R.id.wz_rb:
                        seat = AppConfig.WZ;
                        seatCount = ticketInfo.getWzNum();
                        money = Integer.parseInt(ticketInfo.getWzMoney());
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
                doSubmit();
                break;
            case R.id.add_member_btn:
                turnForResult(SelectMemberActivity.class, SELECT_MEMBER);
                break;
            default:
                break;
        }
    }

    /**
     * 提交
     */
    @Override
    public void doSubmit() {
        if (memberListBean.getMembers() != null && memberListBean.getMembers().size() > 0) {
            if (!seatCount.equals("--") && !seatCount.equals("无")) {
                if (seat.equals("无座")) {
                    seatNo = "无";
                }
                //拼装车票信息提示
                String message = "当前所选车次为" + startDate + " " + ticketInfo.getStartTime() + "发出的"
                        + ticketInfo.getTrainCode() + "次列车，您的座位为" + carriage + "车" + seatNo
                        + "座。车票价格为" + money + "元";
                //弹出确认框
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(message);
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ProgressDialogUtils.showProgress(TicketDetailActivity.this, "正在生成订单...");
                        OrderBean orderBean = new OrderBean();
                        orderBean.setAccount(TrainTicketApplication.getUser().getAccount());
                        orderBean.setTrainNo(ticketInfo.getTrainCode());
                        orderBean.setFromStation(ticketInfo.getStartStationName());
                        orderBean.setStartTime(ticketInfo.getStartTime());
                        orderBean.setToStation(ticketInfo.getToStationName());
                        orderBean.setEndTime(ticketInfo.getArriveTime());
                        orderBean.setDate(startDate);
                        orderBean.setSeat(seat);
                        orderBean.setCarriage(carriage + "");
                        orderBean.setSeatNo(seatNo);
                        orderBean.setMoney(money + "");
                        orderBean.setType(type);
                        ticketDetailPresenter.doSubmit(orderBean);
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.seat_none_tip);
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        } else {
            ToastUtils.show(this, R.string.select_member_tip);
        }
    }

    /**
     * 生成订单成功
     *
     * @param orderBean
     */
    @Override
    public void orderSuccess(OrderBean orderBean) {
        ProgressDialogUtils.hideProgress();
        Bundle bundle = new Bundle();
        bundle.putParcelable("order", orderBean);
        turnThenFinish(PayTicketActivity.class, bundle);
    }

    /**
     * 生成订单失败
     *
     * @param msg
     */
    @Override
    public void orderFailed(String msg) {
        ProgressDialogUtils.hideProgress();
        ToastUtils.show(this, msg);
    }

    /**
     * 处理上个页面返回的结果
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == SELECT_MEMBER) {
            memberListBean = data.getExtras().getParcelable("member");
            setMemberList(memberListBean.getMembers());
        }
    }

    /**
     * 设置乘客列表
     *
     * @param members
     */
    public void setMemberList(List<MemberBean> members) {
        //配置数据到Adapter
        CommonAdapter<MemberBean> memberAdapter = new CommonAdapter<MemberBean>(this, R.layout.view_ticket_member_liet_item, members) {
            @Override
            public void convert(final CommonViewHolder holder, MemberBean memberBean) {
                holder.setText(R.id.real_name_tv, memberBean.getMemberRealName());
            }
        };
        //ListView设置Adapter
        memberList.setAdapter(memberAdapter);
    }
}
