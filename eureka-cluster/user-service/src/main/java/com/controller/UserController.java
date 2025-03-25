package com.controller;

import org.springframework.web.bind.annotation.*;
import pojo.User;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @RequestMapping("/getUser")
    public User getUser(){
        System.out.println("-----getUser-----");
        User user=new User();
        user.setUsername("张三");
        user.setAge(20);

        return user;
    }

    @RequestMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Integer id){
        System.out.println("-------getUserById--------id:"+id);
        if(id==1){
            return new User("zhang",20,0);
        } else if (id==2) {
            return new User("li",20,0);
        }else if (id==3) {
            return new User("wang",20,0);
        } else {
            return null;
        }
    }

    @RequestMapping("/getUserList")
    public List<User> getUserList(){
        List<User> users=new ArrayList<>();
        users.add(new User("L1",20,0));
        users.add(new User("L2",30,0));
        users.add(new User("L3",40,0));
        users.add(new User("L4",50,0));
        return users;
    }

    @RequestMapping("/save")
    public int save(@RequestBody User user){
        System.out.println("-----------save----------user:"+user);
        return 1;
    }
}
