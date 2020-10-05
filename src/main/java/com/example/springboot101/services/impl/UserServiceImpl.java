package com.example.springboot101.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.springboot101.models.User;
import com.example.springboot101.services.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public List<User> findAll() {

        List<User> users = new ArrayList<User>();

        final User user1 = new User("aljaghko", "Khalid Aljaghthami");
        final User user2 = new User("alzoz", "Azoz Aljaghthami");
        final User user3 = new User("alamni", "Amani Aljaghthami");

        users.add(user1);
        users.add(user2);
        users.add(user3);


        return users;
    }
    
}