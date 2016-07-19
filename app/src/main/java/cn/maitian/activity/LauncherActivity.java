package cn.maitian.activity;

import android.os.Bundle;

import cn.maitian.base.BaseActivity;
import cn.maitian.event.BaseEvent;
import cn.maitian.util.IntentUtil;
import cn.maitian.util.LogUtil;

/**
 * launcher activity
 */
public class LauncherActivity extends BaseActivity {
    private static final String TAG = LauncherActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(IntentUtil.generateIntent(this, MainActivity.class));
    }

    @Override
    public void onEvent(BaseEvent event) {
        super.onEvent(event);
        LogUtil.i("%1$s,onEvent", TAG);
    }
}
