package com.cwzsmile.redis.d;

/**
 * Created by Administrator on 2018/9/22 0022.
 */
public abstract class AbstractDecorator extends ABattercake {

    private ABattercake aBattercake;

    public AbstractDecorator(ABattercake aBattercake) {
        this.aBattercake = aBattercake;
    }

    abstract void  doSomething();

    @Override
    String getDesc() {
        return null;
    }

    @Override
    int cost() {
        return 0;
    }
}
