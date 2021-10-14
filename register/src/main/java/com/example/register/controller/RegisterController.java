package com.example.register.controller;

import com.example.register.entity.User;
import com.example.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：LiChao
 * @date ：Created in 2021/10/14 18:41
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("rservice")
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @RequestMapping("register")
    public int register(){
        int status;
        User user;
        user.setUserName("123");
        user.setPassword("123");
        user.setPhoneNumber("123");
        status = registerService.insert(user);
        if (status == 1){
            return 1;
        }else if (status == 0){
            return 0;
        }
    }
}
