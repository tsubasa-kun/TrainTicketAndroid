package com.wyt.trainticket.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;

import com.love_cookies.cookie_library.activity.BaseActivity;
import com.wyt.trainticket.R;

import org.xutils.view.annotation.ContentView;

/**
 * Created by cookie on 2017/3/15 0015.
 * <p>
 * 启动页
 */
@ContentView(R.layout.activity_splash)
public class SplashActivity extends BaseActivity {

    private final int SPLASH_DISPLAY_DURATION = 1500;//启动页显示时长
    private Looper looper = Looper.myLooper();
    private Handler handler = new Handler(looper);

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            turnThenFinish(LoginActivity.class);
        }
    };

    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @Override
    public void initWidget(Bundle savedInstanceState) {
        handler.postDelayed(runnable, SPLASH_DISPLAY_DURATION);
    }

    /**
     * 控件点击事件
     *
     * @param view
     */
    @Override
    public void widgetClick(View view) {

    }

    /**
     * 重写物理按键
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            handler.removeCallbacks(runnable);
        }
        return super.onKeyDown(keyCode, event);
    }

}
