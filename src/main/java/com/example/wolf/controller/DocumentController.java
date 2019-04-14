package com.example.wolf.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/test/doc")
public class DocumentController {

    @PostMapping("/upload")
    public String upload(HttpServletRequest request){
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        System.out.println(multipartRequest.getFileMap().size());
        return "ok";
    }

}
