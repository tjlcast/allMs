package com.tjlcast.allMs.ms.message;

/**
 * Created by tangjialiang on 2018/8/6.
 */
public class KeyValueMessage extends Message {

    protected String key;

    public KeyValueMessage(String key, String data) {
        this.key = key;
        this.data = data;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key + " -> " + data;
    }
}
