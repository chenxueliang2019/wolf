package com.example.wolf.dao;

import com.example.wolf.entiry.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestDao {
    List<Test> findAll();
    void batchAdd(List<Test> list);
    Test findOne(Integer id);
}
