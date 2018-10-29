package com.cwzsmile.redis.future;

/**
 * Created by csh9016 on 2018/10/29.
 */
public class UserInfo {

    private String username;
    private String password;

    public UserInfo() {
        super();
    }

    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
