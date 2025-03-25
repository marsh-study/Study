package com.controller;


import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;

import java.util.List;

@RestController
public class WebController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getWebUser")
    public User gerWebUser(){
        System.out.println("----getWebUser----");
        return userService.getUser();
    }

    @RequestMapping("/getWebUserById/{id}")
    public User gerWebUserById(@PathVariable Integer id){
        System.out.println("----getWebUserById----");
        return userService.getUserById(id);
    }

    @RequestMapping("/getWebUserList")
    public List<User> gerWebUserList(){
        System.out.println("----getWebUserList----");
        return userService.getUserList();
    }

    @RequestMapping("/save/{username}/{age}")
    public int save(@PathVariable String username,@PathVariable int age){
        User user=new User();
        user.setUsername(username);
        user.setAge(age);
        System.out.println("user:"+user);
        return userService.save(user);
    }
}
