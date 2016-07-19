package cn.maitian.util;

import android.content.Context;
import android.content.Intent;

/**
 * Created by geng on 2016/7/19.
 */
public class IntentUtil {
    public static Intent generateIntent(Context context, Class<?> activityClass) {
        return new Intent(context, activityClass);
    }
}
