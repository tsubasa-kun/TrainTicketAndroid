package com.wyt.trainticket.view.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.love_cookies.cookie_library.utils.KeyBoardUtils;
import com.love_cookies.cookie_library.utils.ProgressDialogUtils;
import com.love_cookies.cookie_library.utils.ToastUtils;
import com.wyt.trainticket.R;
import com.wyt.trainticket.model.bean.UserBean;
import com.wyt.trainticket.presenter.RegisterPersenter;
import com.wyt.trainticket.view.interfaces.IRegisterView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by cookie on 2017/3/16 0016.
 * <p>
 * 注册
 */
@ContentView(R.layout.activity_register)
public class RegisterActivity extends BaseActivity implements IRegisterView {

    private RegisterPersenter registerPersenter = new RegisterPersenter(this);

    @ViewInject(R.id.title_tv)
    private TextView titleTv;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.account_et)
    private EditText accountEt;
    @ViewInject(R.id.password_et)
    private EditText passwordEt;
    @ViewInject(R.id.re_password_et)
    private EditText rePasswordEt;
    @ViewInject(R.id.real_name_et)
    private EditText realNameEt;
    @ViewInject(R.id.id_number_et)
    private EditText idNumberEt;
    @ViewInject(R.id.register_btn)
    private TextView registerBtn;


    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        //设置Title
        titleTv.setText(R.string.register_text);
        //设置Title左按钮
        leftBtn.setImageResource(R.drawable.ic_keyboard_backspace_white);
        //添加按钮点击事件
        leftBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
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
            case R.id.register_btn:
                //软键盘消失
                doRegister();
                KeyBoardUtils.closeKeybord(idNumberEt, this);
                break;
            default:
                break;
        }
    }

    /**
     * 注册
     */
    @Override
    public void doRegister() {
        String account = accountEt.getText().toString();
        String password = passwordEt.getText().toString();
        String rePassword = rePasswordEt.getText().toString();
        String realName = realNameEt.getText().toString();
        String idNumber = idNumberEt.getText().toString();
        if (TextUtils.isEmpty(account)) {
            ToastUtils.show(this, R.string.account_hint);
        } else if (TextUtils.isEmpty(password)) {
            ToastUtils.show(this, R.string.password_hint);
        } else if (TextUtils.isEmpty(rePassword)) {
            ToastUtils.show(this, R.string.re_password_hint);
        } else if (!rePassword.equals(password)) {
            ToastUtils.show(this, R.string.re_password_error_hint);
        } else if (TextUtils.isEmpty(realName)) {
            ToastUtils.show(this, R.string.real_name_hint);
        } else if (TextUtils.isEmpty(idNumber)) {
            ToastUtils.show(this, R.string.id_number_hint);
        } else {
            ProgressDialogUtils.showProgress(this);
            UserBean userBean = new UserBean();
            userBean.setAccount(account);
            userBean.setPassword(password);
            userBean.setRealName(realName);
            userBean.setIdNumber(idNumber);
            registerPersenter.doRegister(userBean);
        }
    }

    /**
     * 注册成功
     */
    @Override
    public void registerSuccess(String msg) {
        ProgressDialogUtils.hideProgress();
        ToastUtils.show(this, msg);
        finish();
    }

    /**
     * 注册失败
     * @param msg
     */
    @Override
    public void registerFailed(String msg) {
        ProgressDialogUtils.hideProgress();
        ToastUtils.show(this, msg);
    }
}
