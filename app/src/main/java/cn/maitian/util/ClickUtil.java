package cn.maitian.util;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;

import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import cn.maitian.event.ViewEvent;

/**
 * Created by geng on 2016/7/21.
 */
public class ClickUtil {
    private static final String LOG_TAG = ClickUtil.class.getSimpleName();
    private static long[] mDoubleHits = new long[2];
    private static long[] mTrangleHits = new long[3];

    public static boolean doubleHit(Context context) {
        return timesHit(context, mDoubleHits);
    }

    public static boolean trangleHit(Context context) {
        return timesHit(context, mTrangleHits);
    }

    private static boolean timesHit(Context context, long[] hits) {
        System.arraycopy(hits, 1, hits, 0, hits.length - 1);
        hits[hits.length - 1] = SystemClock.uptimeMillis();
        return hits[0] >= (SystemClock.uptimeMillis() - 10000);
    }

    public static void onClick(Object sender, String tag, View view) {
        RxView.clicks(view)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(aVoid -> {
                    final ViewEvent event = new ViewEvent(view);
                    event.setTag(tag);
                    event.setSender(sender);
                    EventUtil.postEvent(event);
                });

    }
}
