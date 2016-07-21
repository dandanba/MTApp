package cn.maitian.util;

import com.orhanobut.logger.Logger;

import cn.maitian.BuildConfig;

/**
 * Created by geng on 2016/7/18.
 */
public class LogUtil {
    public static void init() {
        Logger.init(BuildConfig.APPLICATION_ID);
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
