package com.example.wolf.dao;

import com.example.wolf.entiry.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DictDao {

    List<DictAreas> findAreas();

    void insertCustomer(@Param("list") List<DictCustomer> list);

    int countDataNum(@Param("param") QueryParam param);

    List<DictVO> findDictData(@Param("param") QueryParam param,@Param("page") Pageble page);
}
