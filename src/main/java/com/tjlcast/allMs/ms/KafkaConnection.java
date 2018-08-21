package com.tjlcast.allMs.ms;

import com.tjlcast.allMs.Configuration;
import com.tjlcast.allMs.exception.CreateConnectionFailException;
import com.tjlcast.allMs.ms.consumer.Consumer;
import com.tjlcast.allMs.ms.consumer.KafkaConsumer;
import com.tjlcast.allMs.ms.producer.KafkaProducer;
import com.tjlcast.allMs.ms.producer.Producer;
import com.tjlcast.allMs.util.Asserts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tangjialiang on 2018/8/6.
 */
public class KafkaConnection implements Connection {
    public final static Logger LOG = LoggerFactory.getLogger(KafkaConnection.class);

    public static final String AUTO_COMMIT_KEY = "enable.auto.commit";

    private Configuration configuration;

    public KafkaConnection(Configuration configuration) {
        this.validConfiguration(configuration);
        this.configuration = configuration;
    }

    private void validConfiguration(Configuration configuration) {
        Object o = configuration.get(AUTO_COMMIT_KEY);
        if (o != null && !"true".equals(o)) {
            LOG.warn("the " + AUTO_COMMIT_KEY + " is not enable, this where set auto commit offset");
            configuration.add(AUTO_COMMIT_KEY, "true");
        }
    }

    @Override
    public Consumer createConsumer(String topic) throws CreateConnectionFailException {
        Asserts.notNull(configuration, "configuration is not set");
        return new KafkaConsumer(configuration, topic);
    }

    @Override
    public Producer createProducer(String topic) throws CreateConnectionFailException {
        Asserts.notNull(configuration, topic);
        return new KafkaProducer(configuration, topic);
    }
}
