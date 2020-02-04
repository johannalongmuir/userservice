package com.manchesterdigital.userservice.controller;

import com.manchesterdigital.userservice.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public String getUsers(){
        return userRepository.findAll().toString();

    }







}
