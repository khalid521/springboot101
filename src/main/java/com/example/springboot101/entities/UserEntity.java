package com.example.springboot101.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.springboot101.models.User;

// import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Users")
public class UserEntity {


    public UserEntity (User user){
        this.id = user.getId();
        this.name = user.getName();
    }
    
    
    @Column(name = "id")
    @Id
    private String id;

    @Column(name ="name")
    private String name;

    @Column(name ="password")
    private String password;




}