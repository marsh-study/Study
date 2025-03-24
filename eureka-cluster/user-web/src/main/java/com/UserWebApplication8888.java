package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserWebApplication8888 {
    public static void main(String[] args) {
        SpringApplication.run(UserWebApplication8888.class,args);
    }
}
