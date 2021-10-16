package com.example.login.entity;

import lombok.Data;

import java.util.Map;

/**
 * @author ：LiChao
 * @date ：Created in 2021/10/15 13:11
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
