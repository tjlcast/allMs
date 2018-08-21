package com.tjlcast.allMs.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tangjialiang on 2018/8/6.
 */
public class Asserts {

    public final static Logger LOG = LoggerFactory.getLogger(Asserts.class);

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
    }
}
