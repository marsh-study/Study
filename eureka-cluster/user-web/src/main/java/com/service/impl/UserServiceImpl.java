package com.service.impl;

import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pojo.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public User getUser() {
        String url="http://user-service/getUser";
        User user=restTemplate.getForObject(url, User.class);
        return user;
    }
}
