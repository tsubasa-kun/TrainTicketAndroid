package com.wyt.trainticket.view.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.love_cookies.cookie_library.fragment.BaseFragment;
import com.love_cookies.cookie_library.utils.SharedPreferencesUtils;
import com.wyt.trainticket.R;
import com.wyt.trainticket.app.TrainTicketApplication;
import com.wyt.trainticket.view.activity.AboutActivity;
import com.wyt.trainticket.view.activity.LoginActivity;
import com.wyt.trainticket.view.activity.MemberActivity;
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

    public static final int MODIFY_INFO = 0;
    public static final int RESET_PASSWORD = 1;

    @ViewInject(R.id.real_name_tv)
    private TextView realNameTv;
    @ViewInject(R.id.id_number_tv)
    private TextView idNumberTv;
    @ViewInject(R.id.modify_info_btn)
    private TextView modifyInfoBtn;
    @ViewInject(R.id.modify_member_btn)
    private TextView modifyMemberBtn;
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
        modifyMemberBtn.setOnClickListener(this);
        resetPasswordBtn.setOnClickListener(this);
        aboutBtn.setOnClickListener(this);
        exitBtn.setOnClickListener(this);
        //设置基本信息
        setUserInfo();
    }

    /**
     * 设置基本信息
     */
    public void setUserInfo() {
        realNameTv.setText(TrainTicketApplication.getUser().getRealName());
        String idNumber = TrainTicketApplication.getUser().getIdNumber();
        idNumber = idNumber.substring(0, 4) + "**********" + idNumber.substring(14, 18);
        idNumberTv.setText(idNumber);
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
                turnForResult(ModifyInfoActivity.class, MODIFY_INFO);
                break;
            case R.id.modify_member_btn:
                turn(MemberActivity.class);
                break;
            case R.id.reset_password_btn:
                turnForResult(ResetPasswordActivity.class, RESET_PASSWORD);
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

    /**
     * 从上个页面返回执行
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case MODIFY_INFO:
                    setUserInfo();
                    break;
                case RESET_PASSWORD:
                    SharedPreferencesUtils.put(getContext(), "auto_login", false);
                    turnThenFinish(LoginActivity.class);
                    break;
                default:
                    break;
            }
        }
    }
}