package com.manchesterdigital.userservice.controller;

import com.manchesterdigital.userservice.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping({"", "/", "index", "index.html"})
    public String listAllUsers(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "users/index";
    }





}
