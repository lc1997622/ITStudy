package com.example.dorm.entity;

import lombok.Data;

import java.util.Map;

/**
 * @author ：LiChao
 * @date ：Created in 2021/10/19 16:32
 * @description：
 * @modified By：
 * @version: $
 */

@Data
public class Msg {

    int status;
    String msg;
    Map<String,Object> data;
}
