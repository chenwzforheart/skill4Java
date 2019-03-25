package com.cwzsmile.redis.ali;

import java.lang.reflect.Field;

/**
 * Created by csh9016 on 2019/3/25.
 */
public class Swap {

    public static void main(String[] args)throws Exception {
        Integer a = 1;
        Integer b = 2;
        swap(a, b);
        System.out.println(a);
        System.out.println(b);
    }

    public static void swap1(Integer a,Integer b) {
        //交换a,b的值
    }

    public static void swap(Integer i1, Integer i2) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        Integer tmp = new Integer(i1.intValue());
        field.set(i1, i2.intValue());
        field.set(i2, tmp);
    }

}
