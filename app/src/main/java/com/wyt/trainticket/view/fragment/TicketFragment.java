package com.wyt.trainticket.view.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.love_cookies.cookie_library.fragment.BaseFragment;
import com.love_cookies.cookie_library.utils.KeyBoardUtils;
import com.love_cookies.cookie_library.utils.ToastUtils;
import com.love_cookies.cookie_library.widget.DateAndTimePicker;
import com.wyt.trainticket.R;
import com.wyt.trainticket.config.AppConfig;
import com.wyt.trainticket.model.bean.StationBean;
import com.wyt.trainticket.utils.DateTimeUtils;
import com.wyt.trainticket.view.activity.QueryTicketActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.io.IOException;
import java.io.InputStream;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by cookie on 2017/3/16 0016.
 * <p>
 * 购票
 */
@ContentView(R.layout.fragment_ticket)
public class TicketFragment extends BaseFragment {

    private int model = AppConfig.MODEL_ALL;

    private StationBean stationBean;
    private String[] stations;
    private ArrayAdapter<String> arrayAdapter;

    @ViewInject(R.id.start_station_tv)
    private AutoCompleteTextView startStationTv;
    @ViewInject(R.id.end_station_tv)
    private AutoCompleteTextView endStationTv;
    @ViewInject(R.id.change_btn)
    private ImageView changeBtn;
    @ViewInject(R.id.date_tv)
    private TextView dateBtn;
    @ViewInject(R.id.student_cb)
    private CheckBox studentCb;
    @ViewInject(R.id.model_rg)
    private RadioGroup modelRg;
    @ViewInject(R.id.query_btn)
    private TextView queryBtn;

    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        //获取站点信息
        getStation();
        //设置按钮点击事件
        changeBtn.setOnClickListener(this);
        dateBtn.setOnClickListener(this);
        queryBtn.setOnClickListener(this);
        //设置自动提示
        arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, stations);
        startStationTv.setAdapter(arrayAdapter);
        endStationTv.setAdapter(arrayAdapter);
        //设置火车类型选择监听器
        modelRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getCheckedRadioButtonId()) {
                    default:
                    case R.id.model_all_rb:
                        model = AppConfig.MODEL_ALL;
                        break;
                    case R.id.model_gdc_rb:
                        model = AppConfig.MODEL_GDC;
                        break;
                    case R.id.model_z_rb:
                        model = AppConfig.MODEL_Z;
                        break;
                    case R.id.model_t_rb:
                        model = AppConfig.MODEL_T;
                        break;
                    case R.id.model_k_rb:
                        model = AppConfig.MODEL_K;
                        break;
                    case R.id.model_other_rb:
                        model = AppConfig.MODEL_OTHER;
                        break;
                }
            }
        });
        //获取当前时间配置在出发日期上
        dateBtn.setText(DateTimeUtils.getInstance().getCurrentTime().substring(0, 10));
    }

    /**
     * 控件点击事件
     *
     * @param view
     */
    @Override
    public void widgetClick(View view) {
        switch (view.getId()) {
            case R.id.change_btn:
                changeStation();
                break;
            case R.id.date_tv:
                selectDate();
                break;
            case R.id.query_btn:
                queryTicket();
                break;
            default:
                break;
        }
    }

    /**
     * 始末站交替
     */
    public void changeStation() {
        //取出始末站
        String tempStart = startStationTv.getText().toString();
        String tempEnd = endStationTv.getText().toString();
        //替换始末站
        startStationTv.setText(tempEnd);
        endStationTv.setText(tempStart);
        //软键盘消失
        KeyBoardUtils.closeKeybord(startStationTv, getContext());
        KeyBoardUtils.closeKeybord(endStationTv, getContext());
        //清除焦点
        startStationTv.clearFocus();
        endStationTv.clearFocus();
    }

    /**
     * 选择日期
     */
    public void selectDate() {
        DateAndTimePicker dateAndTimePicker = new DateAndTimePicker(getActivity(), DateTimeUtils.getInstance().getCurrentTime());
        dateAndTimePicker.datePicKDialog(dateBtn);
    }

    /**
     * 获取站点信息
     */
    public void getStation() {
        try {
            //读取assets下的station.json文件
            InputStream inputStream = getResources().getAssets().open("station.json");
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            String cityJson = new String(buffer, "utf-8");
            //转换为实体类
            Gson gson = new Gson();
            stationBean = gson.fromJson(cityJson, StationBean.class);
            //转换为String数组供Adapter使用
            int length = stationBean.getStation_info().size();
            stations = new String[length];
            for (int i = 0; i < length; i++) {
                stations[i] = stationBean.getStation_info().get(i).getStation();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取站点的Code
     *
     * @param stationName
     * @return
     */
    public String getStationCode(String stationName) {
        String stationCode = "";
        //遍历站点信息，根据站点名匹配Code并返回
        for (StationBean.StationInfoEntity stationInfoEntity : stationBean.getStation_info()) {
            if (stationInfoEntity.getStation().equals(stationName)) {
                stationCode = stationInfoEntity.getCode();
            }
        }
        return stationCode;
    }

    /**
     * 查询车票
     */
    public void queryTicket() {
        String startText = startStationTv.getText().toString();
        String endText = endStationTv.getText().toString();
        if (TextUtils.isEmpty(startText)) {
            ToastUtils.show(getContext(), R.string.start_station_in_hint);
        } else if (TextUtils.isEmpty(endText)) {
            ToastUtils.show(getContext(), R.string.end_station_in_hint);
        } else if (endText.equals(startText)) {
            ToastUtils.show(getContext(), R.string.start_end_same_error_hint);
        } else {
            String startCode = getStationCode(startText);
            String endCode = getStationCode(endText);
            String startDate = dateBtn.getText().toString();
            String type = AppConfig.ADULT;
            if (studentCb.isChecked()) {
                type = AppConfig.STUDENT;
            }
            //传递参数到下一页面
            Bundle bundle = new Bundle();
            bundle.putString("startCode", startCode);
            bundle.putString("endCode", endCode);
            bundle.putString("startDate", startDate);
            bundle.putString("type", type);
            bundle.putInt("model", model);
            turn(QueryTicketActivity.class, bundle);
            //软键盘消失
            KeyBoardUtils.closeKeybord(endStationTv, getContext());
        }
    }

}
