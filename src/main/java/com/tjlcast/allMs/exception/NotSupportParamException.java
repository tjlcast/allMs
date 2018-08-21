package com.tjlcast.allMs.exception;

/**
 * Created by tangjialiang on 2018/8/6.
 */
public class NotSupportParamException extends Exception {

    public NotSupportParamException() {

    }

    public NotSupportParamException(String message) {
        super(message);
    }

    public NotSupportParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSupportParamException(Throwable cause) {
        super(cause);
    }

    public NotSupportParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
