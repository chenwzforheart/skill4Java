package com.cwzsmile.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by mc on 2018/1/7.
 */

@RestController
public class IndexController {

    @Autowired
    StringRedisTemplate StringRedisTemplate;

    @RequestMapping("/addKey")
    public void index(String key) {
        StringRedisTemplate.opsForValue().set(key,"你好");
    }

}
