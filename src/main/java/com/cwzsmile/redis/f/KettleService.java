package com.cwzsmile.redis.f;

/**
 * Created by Administrator on 2018/9/24 0024.
 */
public class KettleService {
    public void waterBurning(String who, Water water, int burnTime) {
        //烧水
        int finalTermperature = Math.min(100, water.getTemperature() + burnTime * 20);
        water.setTemperature(finalTermperature);
        System.out.println(who + " 使用水壶烧水，最终水温为 " + finalTermperature);
    }
}
