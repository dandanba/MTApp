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
import cn.maitian.util.IntentUtil;
import cn.trinea.android.common.util.ToastUtils;

public class MainActivity extends BaseActivity {

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

    private void initView() {
        loadTransformationImage("http://www.fancyenglish.com/country/Taj%20Mahal/india_taj_mahal.jpg", mImageView, 2);
        mImageView.setOnClickListener(view -> ToastUtils.show(this, "image click"));
    }

    @OnClick(R.id.button)
    public void onClick(View view) {
//        final String JSON = "{\n" +
//                "  \"name\" : { \"first\" : \"Joe\", \"last\" : \"Sixpack\" },\n" +
//                "  \"gender\" : \"MALE\",\n" +
//                "  \"verified\" : false,\n" +
//                "  \"userImage\" : \"Rm9vYmFyIQ==\"\n" +
//                "}";
//        UserBean user = JacksonUtil.readValue(JSON, UserBean.class);
//        LogUtil.i(user.toString());
//
//        final String json = JacksonUtil.writeValueAsString(user);
//        LogUtil.json(json);
        if (ClickUtil.fastClick(this)) {
            startActivity(IntentUtil.generateIntent(this, AppActivity.class));
        }

    }

}
