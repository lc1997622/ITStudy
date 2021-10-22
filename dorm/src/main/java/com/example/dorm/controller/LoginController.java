package com.example.dorm.controller;

import com.example.dorm.entity.Msg;
import com.example.dorm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private LoginService loginService;

    @PostMapping("login")
    public Msg login(HttpServletResponse response, @RequestBody Map<String,String> loginInfo){
        Msg msg = loginService.login(response,loginInfo);
        return msg;
    }
}
