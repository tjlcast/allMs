package com.tjlcast.allMs.ms.consumer;

import com.tjlcast.allMs.Configuration;
import com.tjlcast.allMs.ms.message.KeyValueMessage;
import com.tjlcast.allMs.util.Asserts;
import com.tjlcast.allMs.util.IOUtil;
import com.tjlcast.allMs.util.PropertiesUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by tangjialiang on 2018/8/7.
 */
public class KafkaConsumer implements Consumer {

    public final static Logger LOG = LoggerFactory.getLogger(org.apache.kafka.clients.consumer.KafkaConsumer.class);

    private Configuration configuration;
    private String topic;

    private org.apache.kafka.clients.consumer.Consumer<String, String> consumer;

    private MessageListener messageListener;

    private boolean receive = false;

    public KafkaConsumer(Configuration configuration, String topic) {
        Asserts.notNull(configuration, "configuration can not be null");
        Asserts.notNull(topic, "topic can not be null");
        this.configuration = configuration;
        this.topic = topic;
        init();
    }

    private void init() {
        Properties properties = PropertiesUtil.convert(this.configuration);
        org.apache.kafka.clients.consumer.KafkaConsumer<String, String> stringStringKafkaConsumer = new org.apache.kafka.clients.consumer.KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList(this.topic));
    }

    @Override
    public void setMessageListener(MessageListener messageListener) {
        if (this.messageListener == null) {
            this.receive = true;
            this.messageListener = messageListener;
            new Thread(new Receive()).start();
        }

        this.messageListener = messageListener;
    }

    @Override
    public void close() throws IOException {
        IOUtil.close(consumer);
    }

    /**
     * 定时从对象处拉取数据，并把数据发送到接口处
     */
    private class Receive implements Runnable {

        @Override
        public void run() {
            while (receive) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    if (messageListener != null) {
                        messageListener.onMessage(new KeyValueMessage(record.key(), record.value()));
                    }
                }
            }
        }
    }
}
