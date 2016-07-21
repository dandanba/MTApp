package cn.maitian.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.maitian.R;
import cn.maitian.base.BaseActivity;
import cn.maitian.util.ClickUtil;
import cn.maitian.util.LogUtil;

public class MainActivity extends BaseActivity {
    public final static String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.button)
    Button mButton;
    @BindView(R.id.imageView)
    ImageView mImageView;
    @BindView(R.id.textView)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentViewById(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        if (ClickUtil.doubleHit(this)) {
            super.onBackPressed();
        }
    }

    @OnClick(R.id.button)
    public void onButtonsClick(View view) {
        ClickUtil.onClick(this, TAG, view);
    }

    @Override
    public void onClick(Object sender, String tag, View view) {
        if (sender == this && TAG.equals(tag)) {
            LogUtil.i("%1$s, onClick", TAG);
        }
    }
}
