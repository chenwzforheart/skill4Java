package com.cwzsmile.redis.f;

/**
 * Created by Administrator on 2018/9/24 0024.
 */
public class Water {
    private int temperature;
    private int capacity;

    public Water() {
        this.temperature = 0;
        this.capacity = 10;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
