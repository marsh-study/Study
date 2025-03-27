package com.pool;

import com.netflix.hystrix.*;
import com.service.UserServiceFeign;
import pojo.User;

public class PoolCommandA extends HystrixCommand<User> {
    private UserServiceFeign userServiceFeign;
    private Integer id;
    public PoolCommandA(UserServiceFeign userServiceFeign) {
        super(
                Setter.withGroupKey(
                        //服务分组
                        HystrixCommandGroupKey.Factory.asKey("PoolCommandAGroup")
                ).andThreadPoolKey(
                        HystrixThreadPoolKey.Factory.asKey("PoolCommandAPool")
                ).andThreadPoolPropertiesDefaults(
                        HystrixThreadPoolProperties.Setter()
                                .withCoreSize(10)
                                .withKeepAliveTimeMinutes(15)
                                .withMaxQueueSize(10)
                                .withQueueSizeRejectionThreshold(100)
                )
                //线程池隔离
                        .andCommandPropertiesDefaults(
                                HystrixCommandProperties.Setter().withExecutionIsolationStrategy(
                                        HystrixCommandProperties.ExecutionIsolationStrategy.THREAD
                                )
                        )
        );
        this.userServiceFeign = userServiceFeign;
    }

    protected User run(){
        System.out.println("PoolCommandA thread id="+Thread.currentThread().getId());

        //根据id查信息
        User user=this.userServiceFeign.getUserById(id);
        return user;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setUserServiceFeign(UserServiceFeign userServiceFeign) {
        this.userServiceFeign = userServiceFeign;
    }
}
