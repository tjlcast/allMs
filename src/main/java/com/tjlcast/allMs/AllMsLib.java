package com.tjlcast.allMs;

import com.tjlcast.allMs.ms.creator.ConnectionCreator;
import com.tjlcast.allMs.ms.creator.KafkaConnectionCreator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tangjialiang on 2018/8/6.
 */
public class AllMsLib {
    private final static Map<MQ, ConnectionCreator> LIB = new HashMap<>();
    static {
        try {
            boolean kafkaExist = null!=Class.forName("org.apache.kafka.clients.producer.Producer") ? true : false;
            LIB.put(MQ.KAFKA, new KafkaConnectionCreator());
        } catch (ClassNotFoundException e) {

        }
    }

    public static ConnectionCreator getConnectionCreator(MQ mq) {
        ConnectionCreator connectionCreator = LIB.get(mq);

        if (connectionCreator == null) {
            throw new NullPointerException("找不到" + mq + "对应的connectionCreator");
        }
        return connectionCreator;
    }
}
