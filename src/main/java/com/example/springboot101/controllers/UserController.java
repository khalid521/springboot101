package com.example.springboot101.controllers;

import com.example.springboot101.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  
   public UserController() {
   }

    // @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public ResponseEntity<?> findAll() throws Exception
    {
        return ResponseEntity.ok(userService.findAll());

    }
    
}