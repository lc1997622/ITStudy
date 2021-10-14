package com.example.register.dao;

import com.example.register.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterDao {
    public int insert(User user);
}
