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
import com.wyt.trainticket.app.TrainTicketApplication;
import com.wyt.trainticket.model.bean.OrderBean;
import com.wyt.trainticket.presenter.PayTicketPresenter;
import com.wyt.trainticket.view.interfaces.IPayTicketView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by cookie on 2017/4/18 0018.
 * <p>
 * 车票支付页
 */
@ContentView(R.layout.activity_pay_ticket)
public class PayTicketActivity extends BaseActivity implements IPayTicketView {

    private String payTyp;
    private OrderBean orderBean;
    private PayTicketPresenter payTicketPresenter = new PayTicketPresenter(this);

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
        orderBean = getIntent().getParcelableExtra("order");
        //设置Title
        titleTv.setText(R.string.pay_ticket);
        //设置Title左按钮
        leftBtn.setImageResource(R.drawable.ic_keyboard_backspace_white);
        //设置应付金额
        shouldPayMoneyTv.setText(String.format(getResources().getString(R.string.should_pay_money), orderBean.getMoney()));
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
        String message = "应付金额为" + orderBean.getMoney() + "元，使用" + payTyp + "支付，是否确认支付购票？";
        //弹出确认框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ProgressDialogUtils.showProgress(PayTicketActivity.this, "支付中...");
                payTicketPresenter.doSubmit(orderBean);
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
     *
     * @param msg
     */
    @Override
    public void payFailed(String msg) {
        ProgressDialogUtils.hideProgress();
        ToastUtils.show(this, msg);
    }
}
