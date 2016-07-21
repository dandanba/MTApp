package cn.maitian.activity;

import android.os.Bundle;

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
        startActivity(IntentUtil.generateIntent(this, MainActivity.class));
    }

}
