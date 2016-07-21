package cn.maitian.base;

import android.support.multidex.MultiDexApplication;

import com.crashlytics.android.Crashlytics;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import cn.maitian.api.ApiService;
import cn.maitian.util.LogUtil;
import cn.maitian.util.Messager;
import cn.maitian.util.RetrofitUtils;
import io.fabric.sdk.android.Fabric;
import retrofit2.Retrofit;

/**
 * Created by geng on 2016/7/18.
 */
public class BaseApplication extends MultiDexApplication {
    private static BaseApplication sBaseApplication;
    private RefWatcher mRefWatcher;
    private Messager mMessager = new Messager();
    private Retrofit mRetrofit = RetrofitUtils.getClient();

    public static BaseApplication getBaseApplication() {
        return sBaseApplication;
    }

    public RefWatcher getRefWatcher() {
        return mRefWatcher;
    }

    public Messager getMessager() {
        return mMessager;
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    public ApiService getApiService() {
        return mRetrofit.create(ApiService.class);
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
