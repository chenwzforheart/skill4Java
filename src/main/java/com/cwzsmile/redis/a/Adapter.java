package com.cwzsmile.redis.a;

/**
 * Created by Administrator on 2018/9/24 0024.
 */
public class Adapter extends Adaptee implements Target{

    @Override
    public void request() {
        System.out.println("适配器");
        super.adapteeRequest();
    }
}
