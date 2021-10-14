package com.example.login.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {

    public String login(String phonenumber);
}
