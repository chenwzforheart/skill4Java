package com.cwzsmile.redis.x;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/9/28 0028.
 */
public class FlyweightFactory {
    /**
     * 定义一个HashMap用于存储享元对象，实现享元池
     */
    private HashMap flyweights = new HashMap();

    public Flyweight getFlyweight(String key) {
        if (flyweights.containsKey(key)) {
            return (Flyweight) flyweights.get(key);
        }
        else {
            Flyweight fw = new ConcreteFlyweight("");
            flyweights.put(key,fw);
            return fw;
        }
    }
}
