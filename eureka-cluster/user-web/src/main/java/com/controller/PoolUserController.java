package com.controller;

import com.service.PoolUserService.PoolUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;

import java.util.List;

@RestController
public class PoolUserController {
    @Autowired
    private PoolUserService poolUserService;

    @RequestMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Integer id){
        return poolUserService.getUserById(id);
    }

    @RequestMapping("/getUserList")
    public List<User> getUserList(){
        return poolUserService.getUserList();
    }
}
