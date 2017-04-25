package com.wyt.trainticket.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.love_cookies.cookie_library.adapter.CommonAdapter;
import com.love_cookies.cookie_library.adapter.CommonViewHolder;
import com.love_cookies.cookie_library.utils.ProgressDialogUtils;
import com.love_cookies.cookie_library.utils.ToastUtils;
import com.wyt.trainticket.R;
import com.wyt.trainticket.app.TrainTicketApplication;
import com.wyt.trainticket.model.bean.MemberBean;
import com.wyt.trainticket.model.bean.MemberListBean;
import com.wyt.trainticket.presenter.MemberPresenter;
import com.wyt.trainticket.view.interfaces.IMemberView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cookie on 2017/4/22 0022.
 * <p>
 * 选择联系人页
 */
@ContentView(R.layout.activity_select_member)
public class SelectMemberActivity extends BaseActivity implements IMemberView {

    private List<MemberBean> memberDatas = new ArrayList<>();
    private List<MemberBean> memberSelected = new ArrayList<>();
    private MemberPresenter memberPresenter = new MemberPresenter(this);

    @ViewInject(R.id.title_tv)
    private TextView titleTv;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.member_list)
    private ListView memberList;
    @ViewInject(R.id.finish_btn)
    private TextView finishBtn;

    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        //设置Title
        titleTv.setText(R.string.select_member_title);
        //设置Title左按钮
        leftBtn.setImageResource(R.drawable.ic_keyboard_backspace_white);
        //添加按钮点击事件
        leftBtn.setOnClickListener(this);
        finishBtn.setOnClickListener(this);
        //获取联系人
        getMember();
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
            case R.id.finish_btn:
                selectFinish();
                break;
            default:
                break;
        }
    }

    //选中完成
    public void selectFinish() {
        memberSelected.clear();
        for (int i = 0; i < memberDatas.size(); i ++) {
            if (memberDatas.get(i).isChecked()) {
                memberSelected.add(memberDatas.get(i));
            }
        }
        MemberListBean memberListBean = new MemberListBean();
        memberListBean.setMembers(memberSelected);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable("member", memberListBean);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }

    /**
     * 查询联系人
     */
    @Override
    public void getMember() {
        //弹出进度条
        ProgressDialogUtils.showProgress(this);
        //查询联系人
        memberPresenter.doQuery();
    }

    /**
     * 设置联系人列表
     * @param members
     */
    @Override
    public void setMemberList(final List<MemberBean> members) {
        //关闭进度条
        ProgressDialogUtils.hideProgress();
        //配置数据到Adapter
        CommonAdapter<MemberBean> memberAdapter = new CommonAdapter<MemberBean>(this, R.layout.view_select_member_list_item, members) {
            @Override
            public void convert(final CommonViewHolder holder, MemberBean memberBean) {
                CheckBox checkBox = holder.getView(R.id.checkbox);
                checkBox.setChecked(memberBean.isChecked());
                holder.setText(R.id.real_name_tv, memberBean.getMemberRealName());
                String idNumber = memberBean.getMemberIdNumber();
                idNumber = idNumber.substring(0, 4) + "**********" + idNumber.substring(14, 18);
                holder.setText(R.id.id_number_tv, idNumber);
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                        members.get(holder.getPosition()).setChecked(checked);
                        memberDatas = members;
                    }
                });
            }
        };
        //ListView设置Adapter
        memberList.setAdapter(memberAdapter);
    }

    /**
     * 查询失败
     * @param msg
     */
    @Override
    public void queryFailed(String msg) {
        //关闭进度条
        ProgressDialogUtils.hideProgress();
        //弹出提示
        ToastUtils.show(this, msg);
    }
}
