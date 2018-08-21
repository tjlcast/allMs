package com.tjlcast.allMs.ms.consumer;

import com.tjlcast.allMs.ms.message.Message;

/**
 * Created by tangjialiang on 2018/8/6.
 */
public interface MessageListener {

    void onMessage(Message message);
}
