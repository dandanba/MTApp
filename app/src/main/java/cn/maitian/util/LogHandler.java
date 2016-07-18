package cn.maitian.util;

import android.os.Handler;
import android.os.Message;

/**
 * Created by geng on 2016/7/18.
 */
public class LogHandler extends Handler {
    private static final String TAG = LogHandler.class.getSimpleName();

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        LogUtil.i("handleMessage", TAG);
    }
}
