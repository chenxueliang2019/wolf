package com.example.wolf.util;

import com.example.wolf.entiry.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class PageUtil {

    public static Page setPage(int pageNo,int pageSize,int totalRows){
        Page page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setTotalRows(totalRows);
        int totalPage = (totalRows + pageSize - 1)/pageSize;
        page.setTotalPage(totalPage);
        return page;
    }

    public static boolean shouldNotPaging(HttpServletRequest request){
        Map<String,String[]> params = request.getParameterMap();
        return params.containsKey("page") && params.containsKey("size");
    }
}
