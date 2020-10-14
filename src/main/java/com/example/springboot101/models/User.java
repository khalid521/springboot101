package com.example.springboot101.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.springboot101.entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;


import org.springframework.data.annotation.*;
// import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
// @Document(collection = "Users")
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public User (UserEntity user){
        this.id = user.getId();
        this.name = user.getName();
    }
    
    @JsonSerialize(using = ToStringSerializer.class)
    @Id
    private String id;

    private String name;

    @JsonIgnore
    private String password;

}