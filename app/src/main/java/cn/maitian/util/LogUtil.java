package cn.maitian.util;

import com.orhanobut.logger.Logger;

/**
 * Created by geng on 2016/7/18.
 */
public class LogUtil {
    private static final String YOUR_TAG = "maitian";

    public static void init() {
        Logger.init(YOUR_TAG);
    }

    public static void i(String message, Object... args) {
        Logger.i(message, args);
    }

    public static void json(String json) {
        Logger.json(json);
    }

    public static void e(Throwable throwable, String message, Object... args) {
        Logger.e(throwable, message, args);
    }
}
