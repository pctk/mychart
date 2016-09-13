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
//        int anHour = 2 * 1000; // ����2��ĺ�����
//
////                ʹ��SystemClock.elapsedRealtime()������
////                �Ի�ȡ��ϵͳ��������������ʱ��ĺ�������ʹ��System.currentTimeMillis()�������Ի�ȡ
////                ��1970 ��1 ��1 ��0 ������������ʱ��ĺ�������
//        long triggerAtTime = SystemClock.elapsedRealtime() + anHour;
//        Intent it2 = new Intent(MyActivity.this, DengLu.class);
//        PendingIntent pi = PendingIntent.getActivity(this, 0, it2, 0);
//
////                ELAPSED_REALTIME ��ʾ�ö�ʱ����Ĵ���ʱ���ϵͳ������ʼ���𣬵����ỽ��CPU��
////                ELAPSED_REALTIME_WAKEUP ͬ����ʾ�ö�ʱ����Ĵ���ʱ���ϵͳ������ʼ���𣬵��ỽ��CPU��
////                RTC ��ʾ�ö�ʱ����Ĵ���ʱ���1970 ��1��1 ��0 �㿪ʼ���𣬵����ỽ��CPU��
////                RTC_WAKEUP ͬ����ʾ�ö�ʱ����Ĵ���ʱ���1970 ��1 ��1 ��0 �㿪ʼ���𣬵��ỽ��CPU��
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
