package com.example.login.service;

import com.example.login.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public int login(String phonenumber,String password){
        try {
            password = loginDao.login(phonenumber);
            System.out.println(password);

        }catch (Exception e){
            System.out.println(e);
            return 1;
        }
        return 0;
    }
}
