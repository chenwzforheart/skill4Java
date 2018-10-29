package com.cwzsmile.redis.future;

/**
 * Created by csh9016 on 2018/10/29.
 */
public class MyRunnable implements Runnable {
    private UserInfo userInfo;

    public MyRunnable(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public void run() {
        userInfo.setUsername("usernameValue");
        userInfo.setPassword("passwordValue");
    }
}
