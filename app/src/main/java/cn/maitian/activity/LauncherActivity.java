package cn.maitian.activity;

import android.content.Intent;
import android.os.Bundle;

import cn.maitian.base.BaseActivity;

/**
 * launcher activity
 */
public class LauncherActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startActivity(new Intent(this, MainActivity.class));
    }

}
