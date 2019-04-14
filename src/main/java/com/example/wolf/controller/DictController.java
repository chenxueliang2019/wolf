package com.example.wolf.controller;

import com.example.wolf.entiry.DictVO;
import com.example.wolf.entiry.Page;
import com.example.wolf.entiry.Pageble;
import com.example.wolf.service.DictService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/dict")
public class DictController {
    @Resource
    private DictService dictService;

    @GetMapping("/import/customer")
    public String insertCustomer(){
        dictService.insertCustomers();
        return "ok";
    }

    @GetMapping("/get/customer")
    public Page<DictVO> getCustomer(HttpServletRequest request,Integer page,Integer size,String sort){
        page = page == null?1:page;
        size = size == null?10:size;
        sort = sort == null?"id":sort;
        Pageble pageble = new Pageble(page,size,sort);
        Page<DictVO> result = dictService.findDictData(request,pageble);
        return result;
    }
}
