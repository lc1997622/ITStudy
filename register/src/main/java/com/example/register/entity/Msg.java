package com.example.register.entity;

import lombok.Data;

import java.util.Map;

/**
 * @author ：LiChao
 * @date ：Created in 2021/10/15 14:25
 * @description：
 * @modified By：
 * @version: $
 */

@Data
public class Msg {
    int status;
    String Msg;
    Map<String,Object> data;
}
