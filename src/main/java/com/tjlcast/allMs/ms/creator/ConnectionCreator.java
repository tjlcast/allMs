package com.tjlcast.allMs.ms.creator;

import com.tjlcast.allMs.Configuration;
import com.tjlcast.allMs.exception.CreateConnectionFailException;
import com.tjlcast.allMs.ms.Connection;

/**
 * Created by tangjialiang on 2018/8/6.
 */
public interface ConnectionCreator {

    void setConfiguration(Configuration configuration);

    Connection create() throws CreateConnectionFailException;
}
