package com.wyt.trainticket.view.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.love_cookies.cookie_library.utils.KeyBoardUtils;
import com.love_cookies.cookie_library.utils.ProgressDialogUtils;
import com.love_cookies.cookie_library.utils.SharedPreferencesUtils;
import com.love_cookies.cookie_library.utils.ToastUtils;
import com.wyt.trainticket.R;
import com.wyt.trainticket.app.TrainTicketApplication;
import com.wyt.trainticket.model.bean.UserBean;
import com.wyt.trainticket.presenter.LoginPresenter;
import com.wyt.trainticket.view.interfaces.ILoginView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import static com.wyt.trainticket.R.string.auto_login;

/**
 * Created by cookie on 2017/3/16 0016.
 * <p>
 * 登录
 */
@ContentView(R.layout.activity_login)
public class LoginActivity extends BaseActivity implements ILoginView {

    private LoginPresenter loginPresenter = new LoginPresenter(this);

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
        //检测自动登录
        boolean auto_login = (boolean) SharedPreferencesUtils.get(this, "auto_login", false);
        if (auto_login) {
            autoLogin();
        }
        //设置自动登录
        autoLoginCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    SharedPreferencesUtils.put(LoginActivity.this, "auto_login", true);
                } else {
                    SharedPreferencesUtils.put(LoginActivity.this, "auto_login", false);
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
            UserBean userBean = new UserBean();
            userBean.setAccount(account);
            userBean.setPassword(password);
            loginPresenter.doLogin(userBean);
        }
    }

    /**
     * 跳转到主页
     * @param userBean
     */
    @Override
    public void loginSuccess(UserBean userBean) {
        ProgressDialogUtils.hideProgress();
        TrainTicketApplication.setUser(userBean);
        SharedPreferencesUtils.put(this, "account", userBean.getAccount());
        SharedPreferencesUtils.put(this, "password", userBean.getPassword());
        turnThenFinish(MainActivity.class);
        //软键盘消失
        KeyBoardUtils.closeKeybord(passwordEt, this);
    }

    /**
     * 登录失败
     *
     * @param msg
     */
    @Override
    public void loginFailed(String msg) {
        ProgressDialogUtils.hideProgress();
        ToastUtils.show(this, msg);
    }

    /**
     * 自动登录
     */
    @Override
    public void autoLogin() {
        ProgressDialogUtils.showProgress(this);
        UserBean userBean = new UserBean();
        String account = (String) SharedPreferencesUtils.get(this, "account", "");
        String password = (String) SharedPreferencesUtils.get(this, "password", "");
        userBean.setAccount(account);
        userBean.setPassword(password);
        loginPresenter.doLogin(userBean);
    }
}
