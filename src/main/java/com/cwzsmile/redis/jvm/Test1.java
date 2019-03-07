package com.cwzsmile.redis.jvm;

/**
 * Created by csh9016 on 2019/3/7.
 */
public class Test1 {

    private static final int div = 0;

    //1->finally -> return

    public static void main(String[] args) {
        System.out.println(m3());
    }

    private static int m1() {
        try {
            int a = 10 / div;
            System.out.println("num is " + a);
            return 0;
        } catch (Exception e) {
            System.out.println("catch");
            return 1;
        } finally {
            System.out.println("finally");
            return 2;
        }
        //只要catch或者finally中有return，这里就不能写return；
        //return 3;
    }

    private static int m2() {
        try {
            int a = 10 / div;
            System.out.println("num is " + a);
            return 0;
        } catch (Exception e) {
            System.out.println("catch");
            return 1;
        } finally {
            System.out.println("finally");
        }
    }

    private static int m3() {
        try {
            int a = 10 / div;
            System.out.println("num is " + a);
            return 0;
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
        return 3;
    }
}
