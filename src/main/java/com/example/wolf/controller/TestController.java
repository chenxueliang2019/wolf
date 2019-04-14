package com.example.wolf.controller;

import com.example.wolf.dao.TestDao;
import com.example.wolf.entiry.Test;
import com.example.wolf.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @Resource
    private TestDao testDao;
    @Resource
    private RedisService redisService;

    @GetMapping("/hello")
    public String test(){
        return "Hello!";
    }

    @GetMapping("/list")
    public String find(){
        List<Test> list = testDao.findAll();
        System.out.print("--------------------"+list.get(1).getName());
        return "ok";
    }

    @GetMapping("/all")
    public List<Test> findAll(){
        List<Test> list = testDao.findAll();
        System.out.print("--------------------"+list.get(1).getName());
        return list;
    }

    @GetMapping("/add")
    public String add(){

        List<Test> list = new ArrayList<>();
        Test t = new Test("修改",19);
        t.setId(1);
        list.add(t);
        list.add(new Test("新增1",18));
        list.add(new Test("新增2",19));
        testDao.batchAdd(list);
        System.out.print("--------------------"+list.get(1).getName());
        return "ok";
    }
    @GetMapping(value = "/one/{id}",produces = "application/json;charset=UTF-8")
    public Test one(@PathVariable Integer id){
        return redisService.get(id);
    }
    @GetMapping(value = "/ping/{key}",produces = "application/json;charset=UTF-8")
    public String ping(@PathVariable String key){
        Jedis jedis = new Jedis("192.168.1.105",6379);
        System.out.print("----------------------------------"+jedis.ping());

        if(jedis.exists(key)){
            String str = jedis.get(key);
            return str+"走缓存了！";
        }
        jedis.set(key,key);
        jedis.close();
        return key+"没用缓存！";
    }

}
