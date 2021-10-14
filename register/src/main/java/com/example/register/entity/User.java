package com.example.register.entity;

import lombok.Data;

/**
 * @author ：LiChao
 * @date ：Created in 2021/10/14 18:25
 * @description：user
 * @modified By：
 * @version: 1.0$
 */
@Data
public class User {

    Integer id;
    String phoneNumber;
    String userName;
    String password;
}
