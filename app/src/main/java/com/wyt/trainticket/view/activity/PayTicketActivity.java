package com.wyt.trainticket.view.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.love_cookies.cookie_library.utils.ProgressDialogUtils;
import com.love_cookies.cookie_library.utils.ToastUtils;
import com.wyt.trainticket.R;
import com.wyt.trainticket.event.OrderChangeEvent;
import com.wyt.trainticket.model.bean.OrderListBean;
import com.wyt.trainticket.presenter.PayTicketPresenter;
import com.wyt.trainticket.view.interfaces.IPayTicketView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import de.greenrobot.event.EventBus;

/**
 * Created by cookie on 2017/4/18 0018.
 * <p>
 * 车票支付页
 */
@ContentView(R.layout.activity_pay_ticket)
public class PayTicketActivity extends BaseActivity implements IPayTicketView {

    private String payTyp;
    private OrderListBean orderListBean;
    private PayTicketPresenter payTicketPresenter = new PayTicketPresenter(this);
    private int money;

    @ViewInject(R.id.title_tv)
    private TextView titleTv;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.should_pay_money_tv)
    private TextView shouldPayMoneyTv;
    @ViewInject(R.id.pay_typ_rg)
    private RadioGroup payTypRg;
    @ViewInject(R.id.gsyh)
    private RadioButton gsyhRb;
    @ViewInject(R.id.submit_btn)
    private TextView submitBtn;

    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        //获取前一个页面传过来的数据
        orderListBean = getIntent().getParcelableExtra("orderList");
        //设置Title
        titleTv.setText(R.string.pay_ticket);
        //设置Title左按钮
        leftBtn.setImageResource(R.drawable.ic_keyboard_backspace_white);
        //设置应付金额
        money = orderListBean.getOrders().size() * Integer.parseInt(orderListBean.getOrders().get(0).getMoney());
        shouldPayMoneyTv.setText(String.format(getResources().getString(R.string.should_pay_money), money + ""));
        //添加按钮点击事件
        leftBtn.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
        payTypRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                RadioButton radioButton = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
                payTyp = radioButton.getText().toString();
            }
        });
        //设置默认选中项
        gsyhRb.setChecked(true);
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
            default:
                break;
        }
    }

    /**
     * 提交
     */
    @Override
    public void doSubmit() {
        //拼装车票信息提示
        String message = "应付金额为" + money + "元，使用" + payTyp + "支付，是否确认支付购票？";
        //弹出确认框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ProgressDialogUtils.showProgress(PayTicketActivity.this, "支付中...");
                payTicketPresenter.doSubmit(orderListBean);
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
    }

    /**
     * 支付成功
     *
     * @param orderListBean
     */
    @Override
    public void paySuccess(OrderListBean orderListBean) {
        ProgressDialogUtils.hideProgress();
        for (int i = 0; i < orderListBean.getOrders().size(); i ++) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("order", orderListBean.getOrders().get(i));
            turnThenFinish(OutTicketActivity.class, bundle);
            EventBus.getDefault().post(new OrderChangeEvent());
        }
    }

    /**
     * 支付失败
     *
     * @param msg
     */
    @Override
    public void payFailed(String msg) {
        ProgressDialogUtils.hideProgress();
        ToastUtils.show(this, msg);
    }
}
