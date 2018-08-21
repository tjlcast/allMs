package com.tjlcast.allMs.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by tangjialiang on 2018/8/6.
 */
public class IOUtil {

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeable = null;
            }
        }
    }
}
