package com.yunweather.android.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by dell on 2016.05.06.
 */
public class MyApplication extends Application {
    private static Context context;
    public void onCreate(){
        context = getApplicationContext();
    }
    public static Context getContext(){
        return  context;
    }
}
