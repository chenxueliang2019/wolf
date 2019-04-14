package com.example.wolf.service;

import com.example.wolf.entiry.Test;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RedisService {
    boolean setCache(String key,Object value,long time);
    boolean setCache(String key,Object value);
    Test get(String key);
    List<Test> list();
    Test get(Integer id);
}
