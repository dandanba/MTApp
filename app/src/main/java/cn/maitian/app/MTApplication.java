package cn.maitian.app;

/**
 * Created by geng on 2016/7/16.
 */
public class MTApplication extends BaseApplication {
    private static MTApplication sInstance;

    public static MTApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
}
