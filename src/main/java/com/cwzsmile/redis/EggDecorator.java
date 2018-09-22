package com.cwzsmile.redis;

/**
 * Created by Administrator on 2018/9/22 0022.
 */
public class EggDecorator extends AbstractDecorator {

    public EggDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    void doSomething() {

    }

    @Override
    String getDesc() {
        return super.getDesc();
    }

    @Override
    int cost() {
        return super.cost();
    }
}
