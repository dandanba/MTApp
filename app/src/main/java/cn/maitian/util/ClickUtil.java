package cn.maitian.util;

import android.content.Context;
import android.os.SystemClock;

/**
 * Created by geng on 2016/7/21.
 */
public class ClickUtil {
    private static final String LOG_TAG = ClickUtil.class.getSimpleName();
    private static int sFastClickCounter = 5;
    private static long[] mHits = new long[sFastClickCounter];

    public static boolean fastClick(Context context) {
        System.arraycopy(mHits, 1, mHits, 0, mHits.length - 1);
        mHits[mHits.length - 1] = SystemClock.uptimeMillis();
        return mHits[0] >= (SystemClock.uptimeMillis() - 500);
    }
}
