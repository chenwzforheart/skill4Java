package com.cwzsmile.redis.jvm;

/**
 * Created by csh9016 on 2019/3/4.
 */
public class Test {

    public static void main(String[] args) {
        //System.out.println(get1());
        //System.out.println(get2());
        System.out.println(get3());
    }

    public int calc() {
        int a = 100;
        int b = 200;
        int c = 300;
        return (a + b) * c;
    }

    public static int get0() {
        return 128;
    }

    public static int get01() {
        return 6;
    }

    public static void get02() {
        return;
    }

    public static int get1() {
        int i = 0;
        return i++;
    }

    public static int get2() {
        int i = 0;
        return ++i;
    }
    public static int get21() {
        int i = 0;
        return i++;
    }

    public static int get3() {
        int i = 0;
        try {
            return i++;
        } finally {
            i++;
        }
    }

    public static int get4() {
        int i =0;
        try {
        } finally {
            return i;
        }
    }
}
