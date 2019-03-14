package com.cwzsmile.redis.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by csh9016 on 2019/3/14.
 */
public class Main {

    public static void main(String[] args) {

        //SoftReference<String> sr = new SoftReference<String>(new String("hello"));
        ReferenceQueue<String> queue = new ReferenceQueue<String>();
        PhantomReference<String> sr = new PhantomReference<String>(new String("hello"), queue);

        System.out.println(sr.get());
        System.gc();                //通知JVM的gc进行垃圾回收
        System.out.println(sr.get());
    }
}
