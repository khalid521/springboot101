package com.example.springboot101.configs;

import org.springframework.context.annotation.Configuration;

@Configuration
public class PreAuthorize {

    public boolean isAdmin(){
        return true;
    }
    
}