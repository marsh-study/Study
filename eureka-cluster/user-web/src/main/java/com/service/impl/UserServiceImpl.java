package com.service.impl;

import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pojo.User;

import java.util.List;

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

    @Override
    public User getUserById(Integer id) {
        String url="http://user-service/getUserById/{id}";
        User user=restTemplate.getForObject(url, User.class,id);
        return user;
    }

    @Override
    public List<User> getUserList() {
        String url="http://user-service/getUserList";
        List<User> users=restTemplate.getForObject(url, List.class);
        return users;
    }

    @Override
    public int save(User user) {
        String url="http://user-service/save";
        int flag=restTemplate.postForObject(url,user, int.class);
        return flag;
    }


}
