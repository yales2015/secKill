package com.yy.redis;

/**
 * Created by yy on 2018/3/2.
 */
public class UserKey extends BasePrefix {
    private UserKey(String prefix){
        super(prefix);
    }
    public static UserKey getById=new UserKey("id");
    public static UserKey getByName=new UserKey("name");
}
