package com.example.springboot101.services;

import java.util.List;

import com.example.springboot101.entities.UserEntity;
import com.example.springboot101.models.User;

public interface UserService {

    public Iterable<UserEntity>  findAll();

    public User insertOne(User user);
    
}