package com.wyt.trainticket.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.love_cookies.cookie_library.utils.ProgressDialogUtils;
import com.love_cookies.cookie_library.utils.SharedPreferencesUtils;
import com.love_cookies.cookie_library.utils.ToastUtils;
import com.wyt.trainticket.R;
import com.wyt.trainticket.app.TrainTicketApplication;
import com.wyt.trainticket.model.bean.UserBean;
import com.wyt.trainticket.presenter.ResetPasswordPresenter;
import com.wyt.trainticket.view.interfaces.IResetPasswordView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by cookie on 2017/3/21 0021.
 * <p>
 * 修改密码页
 */
@ContentView(R.layout.activity_reset_password)
public class ResetPasswordActivity extends BaseActivity implements IResetPasswordView {

    private ResetPasswordPresenter resetPasswordPresenter = new ResetPasswordPresenter(this);

    @ViewInject(R.id.title_tv)
    private TextView titleTv;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.old_password_et)
    private EditText oldPasswordEt;
    @ViewInject(R.id.new_password_et)
    private EditText newPasswordEt;
    @ViewInject(R.id.re_new_password_et)
    private EditText reNewPasswordEt;
    @ViewInject(R.id.submit_btn)
    private TextView submitBtn;

    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        //设置Title
        titleTv.setText(R.string.reset_password);
        //设置Title左按钮
        leftBtn.setImageResource(R.drawable.ic_keyboard_backspace_white);
        //添加按钮点击事件
        leftBtn.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
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
                doReset();
                break;
            default:
                break;
        }
    }

    /**
     * 修改密码
     */
    @Override
    public void doReset() {
        String oldPassword = oldPasswordEt.getText().toString();
        String newPassword = newPasswordEt.getText().toString();
        String reNewPassword = reNewPasswordEt.getText().toString();
        if (TextUtils.isEmpty(oldPassword)) {
            ToastUtils.show(this, R.string.reset_password_old_password_hint);
        } else if (TextUtils.isEmpty(newPassword)) {
            ToastUtils.show(this, R.string.reset_password_new_password_hint);
        } else if (TextUtils.isEmpty(reNewPassword)) {
            ToastUtils.show(this, R.string.reset_password_re_new_password_hint);
        } else if (!reNewPassword.equals(newPassword)) {
            ToastUtils.show(this, R.string.re_password_error_hint);
        } else {
            ProgressDialogUtils.showProgress(this);
            UserBean userBean = new UserBean();
            userBean.setAccount(TrainTicketApplication.getUser().getAccount());
            userBean.setPassword(oldPassword);
            resetPasswordPresenter.doReset(userBean, newPassword);
        }
    }

    /**
     * 修改成功
     * @param userBean
     */
    @Override
    public void resetSuccess(UserBean userBean) {
        ProgressDialogUtils.hideProgress();
        ToastUtils.show(this, userBean.getResMsg());
        setResult(Activity.RESULT_OK);
        finish();
    }

    /**
     * 修改失败
     * @param msg
     */
    @Override
    public void resetFailed(String msg) {
        ProgressDialogUtils.hideProgress();
        ToastUtils.show(this, msg);
    }
}
