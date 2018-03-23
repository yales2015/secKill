package com.yy.redis;

/**
 * Created by yy on 2018/3/2.
 */
public interface KeyPrefix {
    int expireSeconds();

    String getPrefix();
}
