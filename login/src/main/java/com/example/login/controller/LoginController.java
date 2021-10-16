package com.example.login.controller;

import com.example.login.entity.Msg;
import com.example.login.entity.User;
import com.example.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @PostMapping("login")
    public Msg login(@RequestBody Map<String,String> loginInfo){
        Msg msg = loginService.login(loginInfo);
        return msg;
    }
}
