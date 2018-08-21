package com.tjlcast.allMs.util;

import com.tjlcast.allMs.Configuration;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Created by tangjialiang on 2018/8/6.
 */
public class PropertiesUtil {

    public static Properties convert(Configuration configuration) {
        Properties properties = new Properties();
        Iterator<Map.Entry<String, Object>> iterator = configuration.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            properties.put(entry.getKey(), entry.getValue());
        }

        return properties;
    }
}
