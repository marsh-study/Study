package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;

@RestController
public class UserController {
    @RequestMapping("/getUser")
    public User getUser(){
        System.out.println("-----getUser-----");
        User user=new User();
        user.setUsername("张三");
        user.setAge(20);

        return user;
    }
}
