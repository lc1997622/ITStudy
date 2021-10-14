package com.example.server.service;

import com.example.server.dao.TestDao;
import org.springframework.stereotype.Service;

/**
 * @author ：LiChao
 * @date ：Created in 2021/10/14 14:36
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class TestService implements TestDao {
    @Override
    public String get(String name){
        return name;
    }
}
