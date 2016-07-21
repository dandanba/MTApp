package cn.maitian.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;
import cn.maitian.R;
import cn.maitian.base.BaseActivity;
import cn.maitian.event.ViewEvent;
import cn.maitian.util.ClickUtil;
import cn.maitian.util.LogUtil;
import cn.trinea.android.common.util.ToastUtils;

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
        initView();
    }

    @Override
    public void onBackPressed() {
        if (ClickUtil.doubleHit(this)) {
            super.onBackPressed();
        }
    }

    private void initView() {
        loadTransformationImage("http://www.fancyenglish.com/country/Taj%20Mahal/india_taj_mahal.jpg", mImageView, 2);
        mImageView.setOnClickListener(view -> ToastUtils.show(this, "image click"));
    }

    @OnClick(R.id.button)
    public void onButtonsClick(View view) {
        ClickUtil.onClick(this, TAG, view);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ViewEvent event) {
        final String tag = event.getTag();
        if (TAG.equals(tag)) {//
            final View view = event.getView();
            onClick(view);
        }
    }

    public void onClick(View view) {
        LogUtil.i("%1$s, onClick", TAG);
    }
}
