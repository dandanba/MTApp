package cn.maitian.activity;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import cn.maitian.BuildConfig;
import cn.maitian.R;
import cn.maitian.base.BaseActivity;

public class AppActivity extends BaseActivity {

    @BindView(R.id.info_text)
    TextView mInfoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentViewById(R.layout.activity_application);
        initView();
    }

    private void initView() {
        mInfoText.setText(BuildConfig.VERSION_NAME);
    }


}
