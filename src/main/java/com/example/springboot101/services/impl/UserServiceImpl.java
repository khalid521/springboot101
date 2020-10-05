package com.example.springboot101.services.impl;

import com.example.springboot101.services.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public String findAll() {
        return "All Names will be listed";
    }
    
}