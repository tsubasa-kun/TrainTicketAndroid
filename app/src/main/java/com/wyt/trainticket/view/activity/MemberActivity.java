package com.wyt.trainticket.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
import com.wyt.trainticket.event.ModifyMemberEvent;
import com.wyt.trainticket.model.bean.MemberBean;
import com.wyt.trainticket.presenter.MemberPresenter;
import com.wyt.trainticket.view.interfaces.IMemberView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by cookie on 2017/4/20 0020.
 * <p>
 * 管理联系人页面
 */
@ContentView(R.layout.activity_member)
public class MemberActivity extends BaseActivity implements IMemberView {

    private MemberPresenter memberPresenter = new MemberPresenter(this);

    @ViewInject(R.id.title_tv)
    private TextView titleTv;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.right_btn)
    private ImageView rightBtn;
    @ViewInject(R.id.member_list)
    private ListView memberList;

    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        //注册EventBus
        EventBus.getDefault().register(this);
        //设置Title
        titleTv.setText(R.string.modify_member);
        //设置Title左右按钮
        leftBtn.setImageResource(R.drawable.ic_keyboard_backspace_white);
        rightBtn.setImageResource(R.drawable.ic_add_white);
        //添加按钮点击事件
        leftBtn.setOnClickListener(this);
        rightBtn.setOnClickListener(this);
        //查询联系人
        getMember(TrainTicketApplication.getUser().getUserId());
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
            case R.id.right_btn:
                turn(AddMemberActivity.class);
                break;
            default:
                break;
        }
    }

    /**
     * 查询联系人
     * @param userId
     */
    @Override
    public void getMember(String userId) {
        //弹出进度条
        ProgressDialogUtils.showProgress(this);
        //查询联系人
        memberPresenter.doQuery(userId);
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
        CommonAdapter<MemberBean> memberAdapter = new CommonAdapter<MemberBean>(this, R.layout.view_member_list_item, members) {
            @Override
            public void convert(CommonViewHolder holder, MemberBean memberBean) {
                holder.setText(R.id.real_name_tv, memberBean.getMemberRealName());
                String idNumber = memberBean.getMemberIdNumber();
                idNumber = idNumber.substring(0, 4) + "**********" + idNumber.substring(14, 18);
                holder.setText(R.id.id_number_tv, idNumber);
            }
        };
        //ListView设置Adapter
        memberList.setAdapter(memberAdapter);
        //ListView设置点击事件
        memberList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("member", members.get(position));
                turn(EditMemberActivity.class, bundle);
            }
        });
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

    /**
     * 修改联系人事件
     * from {@link AddMemberActivity#addSuccess()}
     * @param modifyMemberEvent
     */
    public void onEvent(ModifyMemberEvent modifyMemberEvent) {
        getMember(TrainTicketApplication.getUser().getUserId());
    }
}
