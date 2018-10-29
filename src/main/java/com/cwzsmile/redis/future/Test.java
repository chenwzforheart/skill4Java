package com.cwzsmile.redis.future;

import java.util.concurrent.*;

/**
 * Created by csh9016 on 2018/10/29.
 */
public class Test {

    FutureTask abc;

    public static void main(String[] args) {
        try {
            UserInfo userInfo = new UserInfo();
            System.out.println(userInfo);
            MyRunnable myRunnable = new MyRunnable(userInfo);

            ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
            Future<UserInfo> future = pool.submit(myRunnable, userInfo);
            System.out.println("begin time=" + System.currentTimeMillis());
            userInfo = future.get();
            System.out.println("get value " + userInfo.getUsername() + " " + userInfo.getPassword());
            System.out.println(" end time =" + System.currentTimeMillis());
            System.out.println(userInfo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
