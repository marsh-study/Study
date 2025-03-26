package com.service;

import com.service.impl.UserServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.User;

import java.util.List;

@FeignClient(value = "user-service",
        fallback = UserServiceFallBack.class,
        contextId = "userServiceFeign"
)
public interface UserServiceFeign {

    @RequestMapping("/getUser")
    User getUser();

    @RequestMapping("/getUserById/{id}")
    User getUserById(@PathVariable Integer id);

    @RequestMapping("/getUserList")
    List<User> getUserList();

    @RequestMapping("/save")
    int save(User user);
}
