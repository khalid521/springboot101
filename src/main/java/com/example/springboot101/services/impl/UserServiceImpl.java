package com.example.springboot101.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.springboot101.entities.UserEntity;
import com.example.springboot101.models.User;
import com.example.springboot101.repositories.UserRepository;
import com.example.springboot101.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {



    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAll() {
      List<UserEntity> userEntities = userRepository.findAll();
      List<User> users = new ArrayList<User>();

        for (UserEntity userEntity : userEntities) {
        users.add(new User(userEntity.getId(), userEntity.getName(), userEntity.getPassword()));
        }
       return users;
      
    }

    @Override
    @Transactional
    public User insertOne(User user) {
        return new User(userRepository.save(new  UserEntity(user)));
    }
    
}