package cn.maitian.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import cn.maitian.event.ViewEvent;
import cn.maitian.util.EventUtil;
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onViewEvent(ViewEvent event) {
        final Object sender = event.getSender();
        final String tag = event.getTag();
        LogUtil.i("%1$s,%2$s,onViewEvent", sender, tag);
        onClick(sender, tag, event.getView());
    }

    public void onClick(Object sender, String tag, View view) {
    }

    public void initContentViewById(int contentViewId) {
        setContentView(contentViewId);
        ButterKnife.bind(this);
    }


}
