package cn.maitian.activity;

import android.os.Bundle;

import butterknife.ButterKnife;
import cn.maitian.R;
import cn.maitian.base.BaseActivity;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
