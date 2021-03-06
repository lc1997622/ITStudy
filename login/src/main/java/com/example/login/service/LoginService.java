package com.example.login.service;

import com.example.login.dao.LoginDao;
import com.example.login.entity.Msg;
import com.example.login.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.util.DigestUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

import java.util.Map;

/**
 * @author ：LiChao
 * @date ：Created in 2021/10/14 19:30
 * @description：
 * @modified By：
 * @version: $
 */

@Service
public class LoginService {
    @Autowired
    LoginDao loginDao;
    private static String salt = "asdwqAsd12_qS";
    private static final String REGEX_PHONENUMBER = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
    private static final String REGEX_PASSWORD = "^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{8,}$";

    @Autowired
    private RedisUtil redisUtil;

    public Msg login(HttpServletResponse response, Map<String, String> loginInfo){

        String phonenumber = loginInfo.get("phoneNumber");
        String password = loginInfo.get("password");
        String pw = new String();

        Msg msg = testInfo(loginInfo);
        if (msg.getStatus() == 300){
            msg.setMsg("请输入正确得账号密码");
            return msg;
        }

        try {
//            String key = "usr" + phonenumber;
//            if(redisUtil.hasKey(key)){
//                pw = (String) redisUtil.get(key);
//                System.out.println("查询缓存pw:");
//                System.out.println(pw);
//            }
//            else {
//                pw = loginDao.login(phonenumber);
//                System.out.println("查询数据库:");
//                System.out.println(redisUtil.set(key,pw) ? "插入成功" : "插入失败");
//            }
            pw = loginDao.login(phonenumber);
            Cookie cookie = new Cookie("phoneNumber",phonenumber);
            cookie.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(cookie);
        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(500);
            msg.setMsg("登录失败");
            return msg;
        }
        String pwMD51 = DigestUtils.md5DigestAsHex(password.getBytes())+salt;
        String pwMD52 = DigestUtils.md5DigestAsHex(pwMD51.getBytes());
        if ((pw == null)||(pwMD52.compareTo(pw) != 0)){
            msg.setStatus(400);
            msg.setMsg("用户名或密码错误");
        }else {
            msg.setStatus(200);
            msg.setMsg("登录成功");
        }
        return msg;
    }

    private Msg testInfo(Map<String,String> loginInfo){
        Msg msg = new Msg();
        if (!Pattern.matches(REGEX_PHONENUMBER,loginInfo.get("phoneNumber"))){
            msg.setStatus(300);
            msg.setMsg("账号格式不正确");
        }else if (!Pattern.matches(REGEX_PASSWORD,loginInfo.get("password"))){
            msg.setStatus(300);
            msg.setMsg("密码格式不正确");
        }
        else {
            msg.setStatus(100);
        }
        return msg;
    }

}
