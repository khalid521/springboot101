package com.example.springboot101.repositories;

import org.springframework.stereotype.Repository;

import com.example.springboot101.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId>{
    
}