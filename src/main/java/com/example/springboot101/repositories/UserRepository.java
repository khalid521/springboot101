package com.example.springboot101.repositories;

import org.springframework.stereotype.Repository;

import com.example.springboot101.entities.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    
}