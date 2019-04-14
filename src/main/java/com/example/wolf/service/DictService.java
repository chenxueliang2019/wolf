package com.example.wolf.service;

import com.example.wolf.entiry.DictVO;
import com.example.wolf.entiry.Page;
import com.example.wolf.entiry.Pageble;

import javax.servlet.http.HttpServletRequest;

public interface DictService {

    void insertCustomers();

    Page<DictVO> findDictData(HttpServletRequest request, Pageble pageble);
}
