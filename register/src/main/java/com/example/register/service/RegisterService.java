package com.example.register.service;

import com.example.register.dao.RegisterDao;
import com.example.register.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：LiChao
 * @date ：Created in 2021/10/14 18:33
 * @description：注册服务
 * @modified By：
 * @version: 1$
 */

@Service
public class RegisterService{
    @Autowired
    RegisterDao registerDao;

    public int insert(User user){
        try {
            registerDao.insert(user);
        }catch (e){
            System.out.println(e);
            return 1;
        }
        return 0;
    }
}
