package com.cwzsmile.redis.jvm;

/**
 * Created by csh9016 on 2019/3/14.
 */
public class Syn {

    public static void main(String[] args)throws Exception{
        Object lock = new Object();
        //主线程先休息两分钟，方便我们通过HSDB工具类来查看线程栈中对象信息
        Thread.sleep(60000 * 2L);
        synchronized (lock){
            System.out.println("主线程获取到锁");
            try {
                //持有锁几分钟
                Thread.sleep(60000 * 2L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程获释放锁");
        }

        System.out.println("主线程多休息一会，方便等待锁降级.");
        Thread.sleep(60000 * 100L);
    }
}
