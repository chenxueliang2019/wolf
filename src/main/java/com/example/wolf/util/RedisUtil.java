package com.example.wolf.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
@Component
public class RedisUtil {
    @Resource
    private  RedisTemplate<String,Object> redisTemplate;

    /**
     * 指定缓存失效时间
     * @param key
     * @param time 时间（秒）
     * @return
     */
    public  boolean expire(String key,long time){
        try{
            if(time>0){
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return  true;
    }

    /**
     * 获取key的过期时间
     * @param key
     * @return
     */
    public  long getExpire(String key){
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public  boolean haskey(String key){
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除缓存
     * @param key
     */
    public  void del(String... key){
        if (key!=null&&key.length>0){
            if (key.length == 1){
                redisTemplate.delete(key[0]);
            }else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * 获取缓存
     * @param key
     * @return
     */
    public  Object get(String key){
        return key == null ? null:redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通放入缓存
     * @param key
     * @param value
     * @return
     */
    public  boolean set(String key,Object value){
        try{
            redisTemplate.opsForValue().set(key,value);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public  boolean set(String key ,Object value,long time){
        try{
            if (time > 0){
                redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
