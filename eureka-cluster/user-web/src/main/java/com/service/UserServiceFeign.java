package com.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.User;

import java.util.List;

@FeignClient(value = "user-service")
public interface UserServiceFeign {

    @RequestMapping("/getUser")
    public User getUser();

    @RequestMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Integer id);

    @RequestMapping("/getUserList")
    public List<User> getUserList();

    @RequestMapping("/save")
    public int save(User user);
}
