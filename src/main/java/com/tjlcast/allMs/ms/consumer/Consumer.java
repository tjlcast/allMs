package com.tjlcast.allMs.ms.consumer;

import java.io.Closeable;

/**
 * Created by tangjialiang on 2018/8/6.
 */
public interface Consumer extends Closeable {

    void setMessageListener(MessageListener messageListener);
}
