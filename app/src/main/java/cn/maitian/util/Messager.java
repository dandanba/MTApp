package cn.maitian.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by geng on 2016/7/18.
 */
public class Messager {
    private final Map<String, Object> maps = new HashMap<>();

    public Messager() {
    }

    public Object getObject(String key) {
        return maps.get(key);
    }

    public Object removeObject(String key) {
        return maps.remove(key);
    }

    public void setObject(String key, Object object) {
        maps.put(key, object);
    }

}
