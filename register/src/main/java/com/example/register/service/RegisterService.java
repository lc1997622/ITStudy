package com.example.register.service;

import com.example.register.dao.RegisterDao;
import com.example.register.entity.Msg;
import com.example.register.entity.Reg;
import com.example.register.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.util.DigestUtils;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author ：LiChao
 * @date ：Created in 2021/10/14 18:33
 * @description：注册服务
 * @modified By：
 * @version: 1$
 */

@Service
public class RegisterService {
    @Autowired
    RegisterDao registerDao;

    /**
     * 正则
     * 手机号：满足条件的11位数字
     * 密码：包含大写字母、小写字母、数字、特殊符号（不是字母，数字，下划线，汉字的字符）的8位以上
     * 用户名：6-21位字母数字组合，数字不能开头
     */
    private static final String REGEX_PHONENUMBER = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
    private static final String REGEX_PASSWORD = "^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{8,}$";
    private static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,20}$";

    //盐，用于混交md5
    private static String salt = "asdwqAsd12_qS";

    public Msg insert(Map<String,String> regInfo) {
        String phoneNumber = regInfo.get("phoneNumber");
        String password = regInfo.get("password");
        String userName = regInfo.get("userName");

        User user = new User();
        Msg msg = new Msg();
        if (!Pattern.matches(REGEX_PHONENUMBER,phoneNumber)){
            msg.setStatus(400);
            msg.setMsg("电话格式不正确");
        }else if (!Pattern.matches(REGEX_PASSWORD,password)){
            msg.setStatus(400);
            msg.setMsg("密码格式错误");
        }else if (!Pattern.matches(REGEX_USERNAME,userName)){
            msg.setStatus(400);
            msg.setMsg("用户名格式不正确");
        }else {
            user.setPhoneNumber(phoneNumber);
            user.setUserName(userName);
            String pwMD51 = DigestUtils.md5DigestAsHex(password.getBytes())+salt;
            String pwMD52 = DigestUtils.md5DigestAsHex(pwMD51.getBytes());
            user.setPassword(pwMD52);
        }
        if (msg.getStatus() == 400){
            return msg;
        }

        try {
            String pw = registerDao.login(phoneNumber);
            if (pw != null){
                msg.setStatus(300);
                msg.setMsg("手机号已被注册过");
                return msg;
            }
            registerDao.insert(user);
            msg.setStatus(200);
            msg.setMsg("注册成功");
        } catch (Exception e) {
            System.out.println(e);
            msg.setStatus(500);
            msg.setMsg("注册失败");
        }
        return msg;
    }
}
