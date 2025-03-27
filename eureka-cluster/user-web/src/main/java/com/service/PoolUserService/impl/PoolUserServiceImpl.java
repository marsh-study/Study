package com.service.PoolUserService.impl;

import com.pool.PoolCommandA;
import com.pool.PoolCommandB;
import com.service.PoolUserService.PoolUserService;
import com.service.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;

import java.util.List;
import java.util.concurrent.Future;

@Service
public class PoolUserServiceImpl implements PoolUserService {

    @Autowired
    private UserServiceFeign userServiceFeign;
    @Override
    public User getUserById(Integer id) {
        PoolCommandA poolCommandA=new PoolCommandA(userServiceFeign);
        poolCommandA.setId(id);
        //执行线程
        Future<User> future=poolCommandA.queue();
        try {
            User user=future.get();
            return user;
        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public List<User> getUserList() {
        PoolCommandB poolCommandB=new PoolCommandB(userServiceFeign);
        Future<List<User>> future=poolCommandB.queue();
        try {
            List<User> userList=future.get();
            return userList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
