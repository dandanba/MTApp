package cn.maitian.activity;

import android.os.Bundle;
import android.os.Message;

import cn.maitian.base.BaseActivity;
import cn.maitian.util.IntentUtil;

/**
 * launcher activity
 */
public class LauncherActivity extends BaseActivity {
    private static final String TAG = LauncherActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getHandler().sendEmptyMessageDelayed(1, 1000);
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what) {
            case 1:
                getHandler().removeCallbacksAndMessages();
                startActivity(IntentUtil.generateIntent(this, MainActivity.class));
                finish();
                break;
            default:
                break;
        }
    }

}
