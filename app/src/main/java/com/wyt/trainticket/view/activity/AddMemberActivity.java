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
import com.wyt.trainticket.event.ModifyMemberEvent;
import com.wyt.trainticket.model.bean.UserBean;
import com.wyt.trainticket.presenter.AddMemberPresenter;
import com.wyt.trainticket.view.interfaces.IAddMemberView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import de.greenrobot.event.EventBus;

/**
 * Created by cookie on 2017/4/22 0022.
 * <p>
 * 添加联系人页
 */
@ContentView(R.layout.activity_add_member)
public class AddMemberActivity extends BaseActivity implements IAddMemberView {

    private AddMemberPresenter addMemberPresenter = new AddMemberPresenter(this);

    @ViewInject(R.id.title_tv)
    private TextView titleTv;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.real_name_et)
    private EditText realNameEt;
    @ViewInject(R.id.id_number_et)
    private EditText idNumberEt;
    @ViewInject(R.id.add_btn)
    private TextView addBtn;

    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        //设置Title
        titleTv.setText(R.string.add_member_title);
        //设置Title左按钮
        leftBtn.setImageResource(R.drawable.ic_keyboard_backspace_white);
        //添加按钮点击事件
        leftBtn.setOnClickListener(this);
        addBtn.setOnClickListener(this);
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
            case R.id.add_btn:
                //软键盘消失
                KeyBoardUtils.closeKeybord(idNumberEt, this);
                doAdd();
                break;
            default:
                break;
        }
    }

    /**
     * 添加
     */
    @Override
    public void doAdd() {
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
            addMemberPresenter.doAdd(realName, idNumber);
        }
    }

    /**
     * 添加成功
     */
    @Override
    public void addSuccess() {
        ProgressDialogUtils.hideProgress();
        ToastUtils.show(this, R.string.add_member_success);
        EventBus.getDefault().post(new ModifyMemberEvent());
        finish();
    }

    /**
     * 添加失败
     * @param msg
     */
    @Override
    public void addFailed(String msg) {
        ProgressDialogUtils.hideProgress();
        ToastUtils.show(this, msg);
    }
}
