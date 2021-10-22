package com.example.dorm.controller;

import com.example.dorm.entity.Msg;
import com.example.dorm.service.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：LiChao
 * @date ：Created in 2021/10/19 16:28
 * @description：
 * @modified By：
 * @version: $
 */

@RestController
@RequestMapping("dservice")
public class DormController {
    @Autowired
    DormService dormService;

    @PostMapping("getdorms")
    public Msg getDorms(HttpServletRequest request, HttpServletResponse response){
        return dormService.getDorms(request,response);
    }
}
