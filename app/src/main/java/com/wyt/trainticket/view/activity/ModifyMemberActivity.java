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
import com.wyt.trainticket.app.TrainTicketApplication;
import com.wyt.trainticket.event.ModifyMemberEvent;
import com.wyt.trainticket.model.bean.MemberBean;
import com.wyt.trainticket.presenter.ModifyMemberPresenter;
import com.wyt.trainticket.view.interfaces.IModifyMemberView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import de.greenrobot.event.EventBus;

/**
 * Created by cookie on 2017/4/22 0022.
 * <p>
 * 编辑联系人页
 */
@ContentView(R.layout.activity_modify_member)
public class ModifyMemberActivity extends BaseActivity implements IModifyMemberView {

    private MemberBean member;
    private ModifyMemberPresenter modifyMemberPresenter = new ModifyMemberPresenter(this);

    @ViewInject(R.id.title_tv)
    private TextView titleTv;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.real_name_et)
    private EditText realNameEt;
    @ViewInject(R.id.id_number_et)
    private EditText idNumberEt;
    @ViewInject(R.id.modify_btn)
    private TextView modifyBtn;
    @ViewInject(R.id.delete_btn)
    private TextView deleteBtn;

    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        //设置Title
        titleTv.setText(R.string.modify_member_title);
        //设置Title左按钮
        leftBtn.setImageResource(R.drawable.ic_keyboard_backspace_white);
        //获取前一个页面传来的值
        member = getIntent().getExtras().getParcelable("member");
        //设置值
        realNameEt.setText(member.getMemberRealName());
        idNumberEt.setText(member.getMemberIdNumber());
        //添加按钮点击事件
        leftBtn.setOnClickListener(this);
        modifyBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
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
            case R.id.modify_btn:
                //软键盘消失
                KeyBoardUtils.closeKeybord(idNumberEt, this);
                doModify();
                break;
            case R.id.delete_btn:
                //软键盘消失
                KeyBoardUtils.closeKeybord(idNumberEt, this);
                doDelete();
                break;
            default:
                break;
        }
    }

    /**
     * 修改
     */
    @Override
    public void doModify() {
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
            MemberBean memberBean = new MemberBean();
            memberBean.setId(member.getId());
            memberBean.setUserId(member.getUserId());
            memberBean.setMemberRealName(realName);
            memberBean.setMemberIdNumber(idNumber);
            modifyMemberPresenter.doModify(memberBean);
        }
    }

    /**
     * 修改成功
     * @param msg
     */
    @Override
    public void modifySuccess(String msg) {
        ProgressDialogUtils.hideProgress();
        ToastUtils.show(this, msg);
        EventBus.getDefault().post(new ModifyMemberEvent());
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

    /**
     * 删除
     */
    @Override
    public void doDelete() {
        ProgressDialogUtils.showProgress(this);
        modifyMemberPresenter.doDelete(member);
    }

    /**
     * 删除成功
     * @param msg
     */
    @Override
    public void deleteSuccess(String msg) {
        ProgressDialogUtils.hideProgress();
        ToastUtils.show(this, msg);
        EventBus.getDefault().post(new ModifyMemberEvent());
        finish();
    }

    /**
     * 删除失败
     * @param msg
     */
    @Override
    public void deleteFailed(String msg) {
        ProgressDialogUtils.hideProgress();
        ToastUtils.show(this, msg);
    }
}
