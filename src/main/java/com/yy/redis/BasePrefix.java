package com.yy.redis;

/**
 * Created by yy on 2018/3/2.
 */
public abstract class BasePrefix implements KeyPrefix{

    private int expireSeconds;
    private String prefix;
    public BasePrefix(int expireSeconds,String prefix){
        this.expireSeconds=expireSeconds;
        this.prefix=prefix;
    }

    public BasePrefix(String prefix){//默认0代表永不过期
        this.expireSeconds=0;
        this.prefix=prefix;
    }
    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className=getClass().getSimpleName();
        return className+":"+prefix;
    }


}
