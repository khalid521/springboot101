package com.example.support.services;

import java.util.List;

import com.example.support.models.User;

public interface UserService {

    public List<User>  findAll();

    public User insertOne(User user);
    
}