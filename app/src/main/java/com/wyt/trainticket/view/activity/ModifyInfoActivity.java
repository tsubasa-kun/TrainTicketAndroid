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
import com.wyt.trainticket.presenter.ModifyInfoPresenter;
import com.wyt.trainticket.view.interfaces.IModifyInfoView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by cookie on 2017/3/21 0021.
 * <p>
 * 修改信息页
 */
@ContentView(R.layout.activity_modify_info)
public class ModifyInfoActivity extends BaseActivity implements IModifyInfoView {

    private ModifyInfoPresenter modifyInfoPresenter = new ModifyInfoPresenter(this);

    @ViewInject(R.id.title_tv)
    private TextView titleTv;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.real_name_et)
    private EditText realNameEt;
    @ViewInject(R.id.id_number_et)
    private EditText idNumberEt;
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
        titleTv.setText(R.string.modify_info);
        //设置Title左按钮
        leftBtn.setImageResource(R.drawable.ic_keyboard_backspace_white);
        //添加按钮点击事件
        leftBtn.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
        //设置默认值
        realNameEt.setText(TrainTicketApplication.getUser().getRealName());
        idNumberEt.setText(TrainTicketApplication.getUser().getIdNumber());
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
                doModify();
                break;
            default:
                break;
        }
    }

    /**
     * 修改信息
     */
    @Override
    public void doModify() {
        String account = (String) SharedPreferencesUtils.get(this, "account", "");
        String realName = realNameEt.getText().toString();
        String idNumber = idNumberEt.getText().toString();
        if (TextUtils.isEmpty(realName)) {
            ToastUtils.show(this, R.string.real_name_hint);
        } else if (TextUtils.isEmpty(idNumber)) {
            ToastUtils.show(this, R.string.id_number_hint);
        } else if (idNumber.length() != 18) {
            ToastUtils.show(this, R.string.id_number_error_hint);
        } else {
            ProgressDialogUtils.showProgress(this);
            UserBean userBean = new UserBean();
            userBean.setUserId(TrainTicketApplication.getUser().getUserId());
            userBean.setRealName(realName);
            userBean.setIdNumber(idNumber);
            modifyInfoPresenter.doModify(userBean);
        }
    }

    /**
     * 修改成功
     * @param userBean
     */
    @Override
    public void modifySuccess(UserBean userBean) {
        ProgressDialogUtils.hideProgress();
        ToastUtils.show(this, userBean.getResMsg());
        TrainTicketApplication.setUser(userBean);
        setResult(Activity.RESULT_OK);
        finish();
    }

    /**
     * 修改失败
     * @param msg
     */
    @Override
    public void modifyFailed(String msg) {
        ProgressDialogUtils.hideProgress();
        ToastUtils.show(this, msg);
    }
}
