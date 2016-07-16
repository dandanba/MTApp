package cn.maitian.app;

import android.app.Application;

/**
 * Created by geng on 2016/7/16.
 */
public class MTApplication extends Application {
    public static MTApplication getInstance() {
        return sInstance;
    }

    private static MTApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
}
