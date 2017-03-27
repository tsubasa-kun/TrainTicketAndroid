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
import com.wyt.trainticket.config.AppConfig;
import com.wyt.trainticket.model.bean.TicketBean;
import com.wyt.trainticket.presenter.QueryTicketPresenter;
import com.wyt.trainticket.view.interfaces.IQueryTicketView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by cookie on 2017/3/17 0017.
 * <p>
 * 车票查询页
 */
@ContentView(R.layout.activity_query_ticket)
public class QueryTicketActivity extends BaseActivity implements IQueryTicketView {

    private String startCode;
    private String endCode;
    private String startDate;
    private String type;
    private int model;
    private QueryTicketPresenter queryTicketPresenter = new QueryTicketPresenter(this);

    @ViewInject(R.id.title_tv)
    private TextView titleTv;
    @ViewInject(R.id.left_btn)
    private ImageView leftBtn;
    @ViewInject(R.id.right_btn)
    private ImageView rightBtn;
    @ViewInject(R.id.ticket_list)
    private ListView ticketList;

    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        //获取前面页面传递过来的参数
        startCode = getIntent().getStringExtra("startCode");
        endCode = getIntent().getStringExtra("endCode");
        startDate = getIntent().getStringExtra("startDate");
        type = getIntent().getStringExtra("type");
        model = getIntent().getIntExtra("model", AppConfig.MODEL_ALL);
        //设置Title
        titleTv.setText(startDate);
        //设置Title左按钮
        leftBtn.setImageResource(R.drawable.ic_keyboard_backspace_white);
        //设置Title右按钮
        rightBtn.setImageResource(R.drawable.ic_cached_white);
        //添加按钮点击事件
        leftBtn.setOnClickListener(this);
        rightBtn.setOnClickListener(this);
        //车票查询
        doQuery(startCode, endCode, startDate, type, model);
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
                //车票查询
                doQuery(startCode, endCode, startDate, type, model);
                break;
            default:
                break;
        }
    }

    /**
     * 车票查询
     *
     * @param from  出发地
     * @param to    目的地
     * @param date  日期
     * @param type  学生票
     * @param model 车别
     */
    @Override
    public void doQuery(String from, String to, String date, String type, int model) {
        //弹出进度条
        ProgressDialogUtils.showProgress(this);
        //车票查询
        queryTicketPresenter.doQuery(from, to, date, type, model);
    }

    /**
     * 查询成功
     */
    @Override
    public void querySuccess(final TicketBean ticketBean) {
        //关闭进度条
        ProgressDialogUtils.hideProgress();
        //配置数据到Adapter
        CommonAdapter<TicketBean.DataEntity> ticketAdapter = new CommonAdapter<TicketBean.DataEntity>(this, R.layout.view_ticket_list_item, ticketBean.getData()) {
            @Override
            public void convert(CommonViewHolder holder, TicketBean.DataEntity dataEntity) {
                //为每一个字段设置值
                holder.setText(R.id.train_no_tv, dataEntity.getQueryLeftNewDTO().getStation_train_code());
                holder.setText(R.id.start_station_tv, dataEntity.getQueryLeftNewDTO().getFrom_station_name());
                holder.setText(R.id.start_time_tv, dataEntity.getQueryLeftNewDTO().getStart_time());
                holder.setText(R.id.take_time_tv, dataEntity.getQueryLeftNewDTO().getLishi());
                holder.setText(R.id.end_station_tv, dataEntity.getQueryLeftNewDTO().getTo_station_name());
                holder.setText(R.id.end_time_tv, dataEntity.getQueryLeftNewDTO().getArrive_time());
            }
        };
        //ListView设置Adapter
        ticketList.setAdapter(ticketAdapter);
        //ListView设置点击事件
        ticketList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("startDate", startDate);
                bundle.putParcelable("ticket_info", ticketBean.getData().get(position).getQueryLeftNewDTO());
                turn(TicketDetailActivity.class, bundle);
            }
        });
    }

    /**
     * 查询失败
     */
    @Override
    public void queryFailed() {
        ProgressDialogUtils.hideProgress();
        ToastUtils.show(this, R.string.query_ticket_failed);
        finish();
    }

}
