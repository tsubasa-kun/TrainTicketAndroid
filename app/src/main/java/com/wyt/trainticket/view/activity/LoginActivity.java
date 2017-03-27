package com.wyt.trainticket.view.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.love_cookies.cookie_library.utils.KeyBoardUtils;
import com.love_cookies.cookie_library.utils.ProgressDialogUtils;
import com.love_cookies.cookie_library.utils.ToastUtils;
import com.wyt.trainticket.R;
import com.wyt.trainticket.presenter.LoginPresenter;
import com.wyt.trainticket.view.interfaces.ILoginView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by cookie on 2017/3/16 0016.
 * <p>
 * 登录
 */
@ContentView(R.layout.activity_login)
public class LoginActivity extends BaseActivity implements ILoginView {

    @ViewInject(R.id.title_tv)
    private TextView titleTv;
    @ViewInject(R.id.account_et)
    private EditText accountEt;
    @ViewInject(R.id.password_et)
    private EditText passwordEt;
    @ViewInject(R.id.auto_login_cb)
    private CheckBox autoLoginCb;
    @ViewInject(R.id.login_btn)
    private TextView loginBtn;
    @ViewInject(R.id.register_btn)
    private TextView registerBtn;

    private LoginPresenter loginPresenter = new LoginPresenter(this);

    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        //设置title
        titleTv.setText(R.string.login_text);
        //设置按钮点击事件
        loginBtn.setOnClickListener(this);
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
            case R.id.login_btn:
                doLogin();
                break;
            case R.id.register_btn:
                turn(RegisterActivity.class);
                break;
            default:
                break;
        }
    }

    /**
     * 去登录
     */
    @Override
    public void doLogin() {
        String account = accountEt.getText().toString();
        String password = passwordEt.getText().toString();
        if (TextUtils.isEmpty(account)) {
            ToastUtils.show(this, R.string.account_hint);
        } else if (TextUtils.isEmpty(password)) {
            ToastUtils.show(this, R.string.password_hint);
        } else {
            ProgressDialogUtils.showProgress(this);
            loginPresenter.doLogin(account, password);
        }
    }

    /**
     * 跳转到主页
     */
    @Override
    public void turnToMain() {
        ProgressDialogUtils.hideProgress();
        turnThenFinish(MainActivity.class);
        //软键盘消失
        KeyBoardUtils.closeKeybord(passwordEt, this);
    }

    /**
     * 登录失败
     */
    @Override
    public void loginFailed() {
        ProgressDialogUtils.hideProgress();
    }

    /**
     * 自动登录
     */
    @Override
    public void autoLogin() {
        ProgressDialogUtils.showProgress(this);
        loginPresenter.autoLogin();
    }
}
