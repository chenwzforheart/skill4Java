package com.cwzsmile.redis.future;

import java.util.concurrent.*;

/**
 * Created by csh9016 on 2018/10/29.
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyCallable callable = new MyCallable(100);

        try {
            ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
            Future<String> future = executor.submit(callable);
            System.out.println("main A " + System.currentTimeMillis());
            System.out.println(future.get());
            System.out.println("main B" + System.currentTimeMillis());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
