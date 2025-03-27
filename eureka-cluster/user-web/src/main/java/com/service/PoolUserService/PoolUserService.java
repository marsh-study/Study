package com.service.PoolUserService;

import pojo.User;

import java.util.List;

public interface PoolUserService {
    public User getUserById(Integer id);

    public List<User> getUserList();

}
