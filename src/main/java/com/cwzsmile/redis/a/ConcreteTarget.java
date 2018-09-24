package com.cwzsmile.redis.a;

/**
 * Created by Administrator on 2018/9/24 0024.
 */
public class ConcreteTarget implements Target {

    @Override
    public void request() {
        System.out.println("concreteTarget目标方法");
    }
}
