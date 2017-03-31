package com.wyt.trainticket.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.love_cookies.cookie_library.fragment.BaseFragment;
import com.love_cookies.cookie_library.utils.SharedPreferencesUtils;
import com.wyt.trainticket.R;
import com.wyt.trainticket.app.TrainTicketApplication;
import com.wyt.trainticket.view.activity.AboutActivity;
import com.wyt.trainticket.view.activity.LoginActivity;
import com.wyt.trainticket.view.activity.ModifyInfoActivity;
import com.wyt.trainticket.view.activity.ResetPasswordActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by cookie on 2017/3/16 0016.
 * <p>
 * 我
 */
@ContentView(R.layout.fragment_me)
public class MeFragment extends BaseFragment {

    @ViewInject(R.id.real_name_tv)
    private TextView realNameTv;
    @ViewInject(R.id.id_number_tv)
    private TextView idNumberTv;
    @ViewInject(R.id.modify_info_btn)
    private TextView modifyInfoBtn;
    @ViewInject(R.id.reset_password_btn)
    private TextView resetPasswordBtn;
    @ViewInject(R.id.about_btn)
    private TextView aboutBtn;
    @ViewInject(R.id.exit_btn)
    private TextView exitBtn;

    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        //设置按钮点击事件
        modifyInfoBtn.setOnClickListener(this);
        resetPasswordBtn.setOnClickListener(this);
        aboutBtn.setOnClickListener(this);
        exitBtn.setOnClickListener(this);
        realNameTv.setText(TrainTicketApplication.getUser().getRealName());
        idNumberTv.setText(TrainTicketApplication.getUser().getIdNumber());
    }

    /**
     * 控件点击事件
     *
     * @param view
     */
    @Override
    public void widgetClick(View view) {
        switch (view.getId()) {
            case R.id.modify_info_btn:
                turn(ModifyInfoActivity.class);
                break;
            case R.id.reset_password_btn:
                turn(ResetPasswordActivity.class);
                break;
            case R.id.about_btn:
                turn(AboutActivity.class);
                break;
            case R.id.exit_btn:
                SharedPreferencesUtils.put(getContext(), "auto_login", false);
                turnThenFinish(LoginActivity.class);
                break;
            default:
                break;
        }
    }
}