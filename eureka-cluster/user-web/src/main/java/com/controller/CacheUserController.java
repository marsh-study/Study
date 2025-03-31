package com.controller;

import com.cacheservice.CacheUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;

@RestController
public class CacheUserController {
    @Autowired
    private CacheUserService cacheUserService;
    @RequestMapping("/getCacheUserById/{id}")
    public User getUserById(@PathVariable int id) {
        return cacheUserService.getUserById(id);
    }
}
