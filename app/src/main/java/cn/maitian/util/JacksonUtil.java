package cn.maitian.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by geng on 2016/7/18.
 */
public class JacksonUtil {
    private final static String TAG = JacksonUtil.class.getSimpleName();
    private final static ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

    public static <T> T readValue(String json, Class<T> valueType) {
        try {
            return mapper.readValue(json, valueType);
        } catch (IOException e) {
            LogUtil.e(e, "%1$s,readValue", TAG);
        }
        return null;
    }

    public static String writeValueAsString(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LogUtil.e(e, "%1$s,writeValueAsString", TAG);
        }
        return null;
    }

    public static ObjectMapper getObjectMapper() {
        return mapper;
    }
}
