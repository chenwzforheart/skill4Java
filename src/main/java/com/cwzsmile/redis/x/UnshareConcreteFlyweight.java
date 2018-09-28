package com.cwzsmile.redis.x;

/**
 * Created by Administrator on 2018/9/28 0028.
 */
public class UnshareConcreteFlyweight extends Flyweight{

    private String allState;

    public UnshareConcreteFlyweight(String intrinsicState) {
        super(intrinsicState);
    }

    @Override
    public void operation(String extrinsicState) {
        super.operation(extrinsicState);
    }
}
