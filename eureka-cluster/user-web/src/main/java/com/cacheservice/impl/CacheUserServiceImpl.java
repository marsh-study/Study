package com.cacheservice.impl;

import com.cache.CacheCommand;
import com.cacheservice.CacheUserService;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.service.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;

@Service
public class CacheUserServiceImpl implements CacheUserService {

    @Autowired
    private UserServiceFeign userServiceFeign;
    @Override
    public User getUserById(int id) {
        //初始化上下文
        HystrixRequestContext context=HystrixRequestContext.initializeContext();
       User user;//保存查询结果
        //执行execute方法会执行run方法，run方法会执行userServiceFeign.getUserById(id)方法
        System.out.println("----------第一次执行---------");
        CacheCommand cacheCommand=new CacheCommand();
        cacheCommand.setId(id);
        cacheCommand.setUserServiceFeign(userServiceFeign);
        user=cacheCommand.execute();
        System.out.println("第一次查询结果："+user);

        System.out.println("----------------第二次执行--------------");
        CacheCommand cacheCommand2=new CacheCommand();
        cacheCommand2.setId(id);
        cacheCommand2.setUserServiceFeign(userServiceFeign);
        user=cacheCommand2.execute();
        System.out.println("第二次查询结果："+user);

        System.out.println("----------------第三次执行--------------");
        CacheCommand cacheCommand3=new CacheCommand();
        cacheCommand3.setId(id);
        cacheCommand3.setUserServiceFeign(userServiceFeign);
        user=cacheCommand3.execute();
        System.out.println("第三次查询结果："+user);
        //关闭上下文
        context.close();
        return user;
    }
}
