package cn.maitian.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.maitian.event.BaseEvent;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        Logger.i("%1$s,onCreate", TAG);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.i("%1$s,onDestroy", TAG);
        BaseApplication.getBaseApplication().getmRefWatcher().watch(this);
        EventBus.getDefault().unregister(this);
    }

    // This method will be called when a BaseEvent is posted (in the UI thread for Toast)
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(BaseEvent event) {
    }

    public void postEvent(Object event) {
        EventBus.getDefault().post(event);
    }
}
