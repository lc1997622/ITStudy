package com.example.login.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author ：LiChao
 * @date ：Created in 2021/10/18 15:34
 * @description：
 * @modified By：
 * @version: $
 */

@Component
public class RedisUtil {
    @Autowired
    RedisTemplate redisTemplate;

    //判断是否存在key
    public  boolean hasKey(String key){
        return redisTemplate.hasKey(key);
    }

    //从redis中获取值
    public  Object get(String key){
        return  redisTemplate.opsForValue().get(key);
    }

    //向redis插入值
    public  boolean set(final String key,Object value){
        boolean result = false;
        try{
            redisTemplate.opsForValue().set(key,value);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  result;
    }

}
