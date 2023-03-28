package com.example.resttemplate.service;

import com.example.resttemplate.model.User;
import com.example.resttemplate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(int id){
        return userRepository.getUser(id);
    }

    public List<User> getAllUser(){
        return userRepository.getAllUser();
    }

    public User createUser(User user){
      return userRepository.createUser(user);
    }
}
