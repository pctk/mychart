package com.example.mychart;

import android.app.Application;
import android.content.Context;

/**
 * Created by ����� on 2016/8/21.
 */
public class MyApplication extends Application{
    private static Context context;
    @Override
    public void onCreate() {
        context = getApplicationContext();
    }
    public static Context getContext() {
        return context;
    }
}
