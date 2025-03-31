package com.cacheservice;

import pojo.User;

public interface CacheUserService {
    //根据id查询用户信息
    public User getUserById(int id);
}
