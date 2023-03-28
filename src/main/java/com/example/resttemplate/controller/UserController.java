package com.example.resttemplate.controller;

import com.example.resttemplate.model.User;
import com.example.resttemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable("id") int id){
        User user = userService.getUser(id);
       return  ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @GetMapping
    public ResponseEntity getAllUser(){
        List<User> users = userService.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user){
       User newUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
}
