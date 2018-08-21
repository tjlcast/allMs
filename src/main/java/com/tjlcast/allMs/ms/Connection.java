package com.tjlcast.allMs.ms;

import com.tjlcast.allMs.exception.CreateConnectionFailException;
import com.tjlcast.allMs.ms.consumer.Consumer;
import com.tjlcast.allMs.ms.producer.Producer;

/**
 * Created by tangjialiang on 2018/8/6.
 */
public interface Connection {

    /**
     * 创建消费者
     * @param topic
     * @return
     * @throws CreateConnectionFailException
     */
    Consumer createConsumer(String topic) throws CreateConnectionFailException;

    /**
     * 创建生产者
     * @param topic
     * @return
     * @throws CreateConnectionFailException
     */
    Producer createProducer(String topic) throws CreateConnectionFailException;
}
