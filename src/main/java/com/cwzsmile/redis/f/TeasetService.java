package com.cwzsmile.redis.f;

/**
 * Created by Administrator on 2018/9/24 0024.
 */
public class TeasetService {

    public Teawater makeTeaWater(String who, Water water, TeaLeaf teaLeaf) {
        String teawater = "一杯容量为 " + water.getCapacity() + ",温度为 " + water.getTemperature() + " 的" + teaLeaf.getTeaName() + " 茶水";
        System.out.println(who + " 泡了" + teawater);
        return new Teawater(teawater);
    }
}
