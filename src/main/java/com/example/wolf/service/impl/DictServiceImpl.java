package com.example.wolf.service.impl;

import com.example.wolf.dao.DictDao;
import com.example.wolf.entiry.*;
import com.example.wolf.service.DictService;
import com.example.wolf.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DictServiceImpl implements DictService {
    @Resource
    private DictDao dictDao;

    public void insertCustomers(){
        List<DictAreas> areas = dictDao.findAreas();
        List<String> areaCodes = areas.stream().map(DictAreas::getAreaCode).collect(Collectors.toList());
        List<DictCustomer> customers = new ArrayList<>();
        long start = System.currentTimeMillis();
        for(String code:areaCodes){
            for(int i=0;i<100;i++){
                customers.add(new DictCustomer(code+"#"+i,code));
            }
            dictDao.insertCustomer(customers);
            customers.clear();
        }
        long end = System.currentTimeMillis();
        System.out.println("录入完成----------------------------" + customers.size() + "---时间---" + (end-start) + "毫秒");

    }

    public Page<DictVO> findDictData(HttpServletRequest request, Pageble pageble){
        QueryParam param = new QueryParam();
        param.setProvinceCode(request.getParameter("provinceCode"));
        param.setCityCode(request.getParameter("cityCode"));
        param.setAreaCode(request.getParameter("areaCode"));
        param.setKeyWord(request.getParameter("keyWord"));
        System.out.println("参数----" + param);
        int totalRow = dictDao.countDataNum(param);
        List<DictVO> data = dictDao.findDictData(param,pageble);
        Page<DictVO> page = PageUtil.setPage(pageble.getPage(),pageble.getSize(),totalRow);
        page.setSort(pageble.getSort());
        page.setData(data);
        return page;

    }
}
