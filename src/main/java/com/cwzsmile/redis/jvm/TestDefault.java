package com.cwzsmile.redis.jvm;

/**
 * Created by csh9016 on 2019/3/8.
 */
public class TestDefault {

    protected boolean interceptFlag;

    public boolean isInterceptFlag() {
        return interceptFlag;
    }

    public static void main(String[] args) {
        System.out.println(new TestDefault().isInterceptFlag());
    }
}
