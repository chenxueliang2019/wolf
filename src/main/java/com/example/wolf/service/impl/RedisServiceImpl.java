package com.example.wolf.service.impl;

import com.example.wolf.dao.TestDao;
import com.example.wolf.entiry.Test;
import com.example.wolf.service.RedisService;
import com.example.wolf.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RedisServiceImpl implements RedisService {
    @Resource
    private TestDao testDao;
    @Resource
    private RedisUtil redisUtil;
    @Override
    public boolean setCache(String key, Object value, long time) {
        return redisUtil.set(key, value, time);
    }

    @Override
    public boolean setCache(String key, Object value) {
        return redisUtil.set(key, value);
    }

    @Override
    public Test get(String key) {
        Object obj = redisUtil.get(key);
        Test ret = null;
        if(obj instanceof Test){
            ret = (Test)obj;
        }
        return ret;
    }

    @Override
    public List<Test> list() {
        List<Test> ret = new ArrayList<>();
        if (redisUtil.haskey("all")){
            System.out.print("-------------------------------缓存了");
            Object obj =  redisUtil.get("all");
            try {
                ret = (List<Test>)obj;
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            ret = testDao.findAll();
            redisUtil.set("all",ret);
        }
        return ret;
    }

    @Override
    public Test get(Integer id) {
        Test test = new Test();
        String key = id + "";
        if (redisUtil.haskey(key)){
            try{
                System.out.print("-------------------------------缓存了"+id);
                test = (Test)redisUtil.get(key);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            test = testDao.findOne(id);
            redisUtil.set(key,test);
        }
        return test;
    }

}
