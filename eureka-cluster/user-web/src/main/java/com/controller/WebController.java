package com.controller;


import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;

@RestController
public class WebController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getWebUser")
    public User gerWebUser(){
        System.out.println("----getWebUser----");
        return userService.getUser();
    }
}
