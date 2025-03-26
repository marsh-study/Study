package com.service.impl;

import com.service.UserServiceFeign;
import org.springframework.stereotype.Component;
import pojo.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceFallBack implements UserServiceFeign {
    @Override
    public User getUser() {
        User user = new User();
        user.setMessage("调用getUser()方法失败");
        return  user;
    }

    @Override
    public User getUserById(Integer id) {
        User user = new User();
        user.setMessage("调用getUserById()方法失败");
        return user;
    }

    @Override
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setMessage("调用getUserList()方法失败");
        userList.add(user);
        return userList;

    }

    @Override
    public int save(User user) {
        User user1 = new User();
        user1.setMessage("调用save()方法失败");
        return -1;
    }
}
