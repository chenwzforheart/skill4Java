package com.cwzsmile.redis.a;

/**
 * Created by Administrator on 2018/9/24 0024.
 */
public class AdapterObj implements Target {
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.adapteeRequest();
    }
}
