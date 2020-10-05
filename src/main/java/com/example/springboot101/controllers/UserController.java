package com.example.springboot101.controllers;

import com.example.springboot101.models.User;
import com.example.springboot101.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.security.access.prepost.PreAuthorize;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  
   public UserController() {
   }

    // @PreAuthorize("isAdmin()")
    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public ResponseEntity<?> findAll() throws Exception
    {
        return ResponseEntity.ok(userService.findAll());

    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public ResponseEntity<?> insertOne(@RequestBody User user) throws Exception
    {

    
        return ResponseEntity.ok(userService.insertOne((user)));

    }
    
}