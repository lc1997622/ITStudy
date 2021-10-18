package com.example.login.controller;

import com.example.login.entity.Msg;
import com.example.login.entity.User;
import com.example.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("login")
    public Msg login(@RequestBody Map<String,String> loginInfo){
        Msg msg = loginService.login(loginInfo);
        return msg;
    }

    @GetMapping("testRedis")
    public int testRedis(){
        stringRedisTemplate.opsForValue().append("msg","coder");
        stringRedisTemplate.opsForList().leftPush("mylist","1");
        stringRedisTemplate.opsForList().leftPush("mylist","2");
        return 0;
    }

    @RequestMapping("session")
    public Map<String,Object> getSession(HttpServletRequest request){
        request.getSession().setAttribute("userName","glmapper");
        Map<String,Object> map = new HashMap<>();
        map.put("sessionId",request.getSession().getId());
        return map;
    }

    @RequestMapping("get")
    public String set(HttpServletRequest request){
        String uName = (String) request.getSession().getAttribute("userName");
        return uName;
    }
}
