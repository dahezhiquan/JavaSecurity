package com.dahe.hello.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
public class User {

    private Integer id;
    @Setter
    private String user;
    private String pass;

}
