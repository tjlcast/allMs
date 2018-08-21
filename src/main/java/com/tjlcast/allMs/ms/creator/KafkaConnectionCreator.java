package com.tjlcast.allMs.ms.creator;

import com.tjlcast.allMs.Configuration;
import com.tjlcast.allMs.exception.CreateConnectionFailException;
import com.tjlcast.allMs.ms.Connection;
import com.tjlcast.allMs.ms.KafkaConnection;
import com.tjlcast.allMs.util.Asserts;

/**
 * Created by tangjialiang on 2018/8/6.
 */
public class KafkaConnectionCreator implements ConnectionCreator {
    private Configuration configuration;

    @Override
    public void setConfiguration(Configuration configuration) {

    }

    @Override
    public Connection create() throws CreateConnectionFailException {
        Asserts.notNull(configuration, "configuration is not set");
        return new KafkaConnection(this.configuration);
    }
}
