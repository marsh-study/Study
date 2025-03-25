package com.service;

import pojo.User;

import java.util.List;


public interface UserService {
    public User getUser();

    public User getUserById(Integer id);

    public List<User> getUserList();

    public int save(User user);
}
