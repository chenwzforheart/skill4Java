package com.cwzsmile.redis.a;

/**
 * Created by Administrator on 2018/9/24 0024.
 */
public interface DC5Adapter {
    boolean support(AC ac);

    int outputDC5V(AC ac);
}
