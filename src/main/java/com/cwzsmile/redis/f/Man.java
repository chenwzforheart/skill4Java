package com.cwzsmile.redis.f;

/**
 * Created by Administrator on 2018/9/24 0024.
 */
public class Man {
    private String name;

    public Man(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void drink(Teawater teawater) {
        System.out.println(name + " 喝了" + teawater.getTeawater());
    }
}
