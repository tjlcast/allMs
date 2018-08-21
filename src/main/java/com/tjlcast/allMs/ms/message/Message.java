package com.tjlcast.allMs.ms.message;

/**
 * Created by tangjialiang on 2018/8/6.
 */
public class Message {

    protected String data;

    public Message() {
    }

    public Message(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data;
    }
}
