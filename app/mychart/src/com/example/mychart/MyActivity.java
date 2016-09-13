package com.example.mychart;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
//        int anHour = 2 * 1000; // 这是2秒的毫秒数
//
////                使用SystemClock.elapsedRealtime()方法可
////                以获取到系统开机至今所经历时间的毫秒数，使用System.currentTimeMillis()方法可以获取
////                到1970 年1 月1 日0 点至今所经历时间的毫秒数。
//        long triggerAtTime = SystemClock.elapsedRealtime() + anHour;
//        Intent it2 = new Intent(MyActivity.this, DengLu.class);
//        PendingIntent pi = PendingIntent.getActivity(this, 0, it2, 0);
//
////                ELAPSED_REALTIME 表示让定时任务的触发时间从系统开机开始算起，但不会唤醒CPU。
////                ELAPSED_REALTIME_WAKEUP 同样表示让定时任务的触发时间从系统开机开始算起，但会唤醒CPU。
////                RTC 表示让定时任务的触发时间从1970 年1月1 日0 点开始算起，但不会唤醒CPU。
////                RTC_WAKEUP 同样表示让定时任务的触发时间从1970 年1 月1 日0 点开始算起，但会唤醒CPU。
//        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);
//        finish();
        CountDownTimer timer = new CountDownTimer(0, 0) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MyActivity.this, DengLu.class);
                startActivity(intent);
                finish();
            }
        };
        timer.start();
    }
}
