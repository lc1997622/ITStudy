package com.example.login.controller;

import com.example.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：LiChao
 * @date ：Created in 2021/10/14 19:34
 * @description：
 * @modified By：
 * @version: $
 */

@RestController
@RequestMapping("lservice")
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("login")
    public int login(){
        int num =100;
        num = loginService.login("11111111111","111");
        return num;
    }
}
