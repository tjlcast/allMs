package com.tjlcast.allMs;

import java.util.HashMap;

/**
 * Created by tangjialiang on 2018/8/6.
 */
public class Configuration extends HashMap<String, Object> {

    public void add(String key, Object obj) {
        this.put(key, obj);
    }
}
