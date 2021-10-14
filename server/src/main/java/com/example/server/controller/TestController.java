package com.example.server.controller;

import com.example.server.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：LiChao
 * @date ：Created in 2021/10/14 14:38
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    TestService testService;
    @RequestMapping("get")
    public String get(String name){
        return testService.get(name);
    }
}
