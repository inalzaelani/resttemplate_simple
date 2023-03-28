package com.example.resttemplate.repository;

import com.example.resttemplate.model.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class UserRepository {
    private RestTemplate restTemplate;

    public UserRepository(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public User getUser(int id){
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/" + id, User.class);
    }

    public List<User> getAllUser(){
        String url = "https://jsonplaceholder.typicode.com/users";
        ResponseEntity<List<User>> response = restTemplate.exchange(url, HttpMethod.GET,null,
                new ParameterizedTypeReference<List<User>>(){});
        List<User> users = response.getBody();
        return users;
    }

    public User createUser(User user){
        restTemplate.postForObject("https://jsonplaceholder.typicode.com/users", user, User.class);
        return user;
    }

}
