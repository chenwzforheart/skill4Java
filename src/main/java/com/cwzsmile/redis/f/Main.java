package com.cwzsmile.redis.f;

/**
 * Created by Administrator on 2018/9/24 0024.
 */
public class Main {
    public static void main(String[] args) {
        Man zhangsan = new Man("张三");
        KettleService kettleService1 = new KettleService();
        TeasetService teasetService1 = new TeasetService();
        Water water1 = new Water();
        TeaLeaf teaLeaf1 = new TeaLeaf("西湖龙井");
        kettleService1.waterBurning(zhangsan.getName(), water1, 4);
        Teawater teawater1 = teasetService1.makeTeaWater(zhangsan.getName(), water1, teaLeaf1);
        zhangsan.drink(teawater1);
        System.out.println();

    }
}
