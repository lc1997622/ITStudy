package com.example.dorm.dao;

import com.example.dorm.entity.Dorm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DormDao {
    public List<Dorm> getDorms();
}
