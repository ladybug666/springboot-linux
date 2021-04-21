package com.ladybug.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Controller
public class RedisController {
    @RequestMapping("redis")
    public String redis(){
        JedisPool pool=new JedisPool("118.195.171.31",6379);
        Jedis jedis=pool.getResource();
        String value=jedis.get("ces");
        System.out.println(value);
        jedis.close();
        return "redis";
    }
}
