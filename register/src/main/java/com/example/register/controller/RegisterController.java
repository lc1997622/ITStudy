package com.example.register.controller;

import com.example.register.entity.Msg;
import com.example.register.entity.Reg;
import com.example.register.entity.User;
import com.example.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

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

    @PostMapping("register")
    public Msg register(@RequestBody Map<String,String> regInfo) {
        Msg msg = registerService.insert(regInfo);
        return msg;
    }
}
