package com.tjlcast.allMs.exception;

/**
 * Created by tangjialiang on 2018/8/6.
 */
public class CreateConnectionFailException extends RuntimeException {

    public CreateConnectionFailException() {

    }

    public CreateConnectionFailException(String message) {
        super(message);
    }

    public CreateConnectionFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateConnectionFailException(Throwable cause) {
        super(cause);
    }

    public CreateConnectionFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
