package cn.maitian.base;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import cn.maitian.util.LogUtil;
import cn.maitian.util.Messager;
import io.fabric.sdk.android.Fabric;

/**
 * Created by geng on 2016/7/18.
 */
public class BaseApplication extends Application {
    private static BaseApplication sBaseApplication;
    private RefWatcher mRefWatcher;
    private Messager mMessager = new Messager();

    public static BaseApplication getBaseApplication() {
        return sBaseApplication;
    }

    public RefWatcher getRefWatcher() {
        return mRefWatcher;
    }

    public Messager getMessager() {
        return mMessager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.init();
        mRefWatcher = LeakCanary.install(this);
        Fabric.with(this, new Crashlytics());
        sBaseApplication = this;
    }
}
