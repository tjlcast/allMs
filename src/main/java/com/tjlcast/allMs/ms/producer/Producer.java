package com.tjlcast.allMs.ms.producer;

import com.tjlcast.allMs.ms.message.Message;

import java.io.Closeable;

/**
 * Created by tangjialiang on 2018/8/6.
 */
public interface Producer extends Closeable {

    void sendMessage(Message message);
}
