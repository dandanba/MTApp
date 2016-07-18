package cn.maitian.util;

import com.orhanobut.logger.Logger;

/**
 * Created by geng on 2016/7/18.
 */
public class LogUtil {
    public static void i(String message, Object... args) {
        Logger.i(message, args);
    }
}
