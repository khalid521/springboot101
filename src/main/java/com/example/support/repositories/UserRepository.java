package com.example.support.repositories;

import org.springframework.stereotype.Repository;

import com.example.support.entities.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    
}