package cn.maitian.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import cn.maitian.event.BaseEvent;
import cn.maitian.util.EventUtil;
import cn.maitian.util.GlideUtil;
import cn.maitian.util.LogHandler;
import cn.maitian.util.LogUtil;

public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();

    private LogHandler mLogHandler = new LogHandler();

    public LogHandler getHandler() {
        return mLogHandler;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventUtil.register(this);
        LogUtil.i("%1$s,onCreate", TAG);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.i("%1$s,onDestroy", TAG);
        BaseApplication.getBaseApplication().getRefWatcher().watch(this);
        EventUtil.unregister(this);
    }

    // This method will be called when a BaseEvent is posted (in the UI thread for Toast)
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(BaseEvent event) {
    }

    public void postEvent(Object event) {
        EventUtil.postEvent(event);
    }

    public void loadImage(String url, ImageView imageView) {
        GlideUtil.loadImage(this, url, imageView);
    }

    public void loadTransformationImage(String url, ImageView imageView, int transformation) {
        GlideUtil.loadTransformationImage(this, url, transformation, imageView);
    }

    public void initContentViewById(int contentViewId) {
        setContentView(contentViewId);
        ButterKnife.bind(this);
    }

}
