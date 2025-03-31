package com.pool;

import com.netflix.hystrix.*;
import com.service.UserServiceFeign;
import pojo.User;

import java.util.List;

public class PoolCommandB extends HystrixCommand<List<User>> {
    private UserServiceFeign userServiceFeign;

    public PoolCommandB(UserServiceFeign userServiceFeign) {
        super(
                Setter.withGroupKey(
                        //服务分组
                        HystrixCommandGroupKey.Factory.asKey("PoolCommandBGroup")
                ).andThreadPoolKey(
                        HystrixThreadPoolKey.Factory.asKey("PoolCommandBPool")
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

    private void setUserServiceFeign(UserServiceFeign userServiceFeign) {
        this.userServiceFeign = userServiceFeign;
    }
    protected List<User> run(){
        System.out.println("PoolCommandB thread id="+Thread.currentThread().getId());

        //根据id查信息
        return this.userServiceFeign.getUserList();
    }
}
