package com.example.springboot101.services;

import java.util.List;

import com.example.springboot101.models.User;

public interface UserService {

    public List<User>  findAll();
    
}