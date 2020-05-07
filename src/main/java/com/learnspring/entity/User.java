package com.learnspring.entity;

import lombok.Data;

@Data
public class User {
    private long id;
    private String name;
    public User(){
        System.out.println("user");
    }
}
