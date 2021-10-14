package com.example.web.controller;

import com.example.server.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：LiChao
 * @date ：Created in 2021/10/14 14:48
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("test")
public class TestWebController {

    @Autowired
    TestService testService;

    @RequestMapping("getTest")
    public String getName(){
        return testService.get("WEB");
    }
}
