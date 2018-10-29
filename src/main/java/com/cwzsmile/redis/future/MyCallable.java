package com.cwzsmile.redis.future;

import java.util.concurrent.Callable;

/**
 * Created by csh9016 on 2018/10/29.
 */
public class MyCallable implements Callable<String> {
    private int age;

    public MyCallable(int age) {
        super();
        this.age = age;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(8000);
        return "返回值 年龄是：" + age;
    }
}
