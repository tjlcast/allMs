package com.tjlcast.allMs.ms.producer;

import com.tjlcast.allMs.Configuration;
import com.tjlcast.allMs.ms.message.KeyValueMessage;
import com.tjlcast.allMs.ms.message.Message;
import com.tjlcast.allMs.util.Asserts;
import com.tjlcast.allMs.util.IOUtil;
import com.tjlcast.allMs.util.PropertiesUtil;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by tangjialiang on 2018/8/6.
 */
public class KafkaProducer implements Producer {

    private Configuration configuration;

    private org.apache.kafka.clients.producer.Producer<String, String> producer;

    protected String topic;

    public KafkaProducer(Configuration configuration) {
        Asserts.notNull(configuration, "configuration can not be null");
        this.configuration = configuration;
        init();
    }

    public KafkaProducer(Configuration configuration, String topic) {
        this(configuration);
        Asserts.notNull(topic, "topic can not be null");
        this.topic = topic;
    }

    private void init() {
        Properties properties = PropertiesUtil.convert(this.configuration);
        this.producer = new org.apache.kafka.clients.producer.KafkaProducer<>(properties);
    }

    @Override
    public void close() throws IOException {
        IOUtil.close(producer);
    }

    @Override
    public void sendMessage(Message message) {
        this.sendMessage(this.topic, message);
    }

    private void sendMessage(String topic, Message message) {
        Asserts.notNull(message, "message not be null");
        if (message instanceof KeyValueMessage) {
            KeyValueMessage keyValueData = (KeyValueMessage) message;
            producer.send(new ProducerRecord<String, String>(topic, keyValueData.getKey(), keyValueData.getData()));
        } else {
            producer.send(new ProducerRecord<String, String>(topic, "", message.getData()));
        }
    }
}
