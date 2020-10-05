package com.example.springboot101.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.springboot101.models.User;
import com.example.springboot101.repositories.UserRepository;
import com.example.springboot101.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {



    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User insertOne(User user) {
        return userRepository.insert(user);
    }
    
}