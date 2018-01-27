package com.dbg.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedisClient {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/tellyou/{key}/{value}")
    @ResponseBody
    public String home(@PathVariable("key") String key, @PathVariable("value") String value){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set(key,value);
        return String.format("%s:%s",key,value);
    }

    @RequestMapping("/tellme/{key}")
    @ResponseBody
    public String tellMe(@PathVariable("key") String key){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        return ops.get(key);
    }


}
