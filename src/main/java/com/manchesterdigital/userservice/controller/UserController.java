package com.manchesterdigital.userservice.controller;

import com.manchesterdigital.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
@Controller
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @GetMapping("/users")
//    public String getUsers(){
//        return userRepository.findAll().toString();
//    }
// @RequestMapping({"", "/"})
//    @RequestMapping("/users")
//    public String showAllUsers(Model model) {
//        model.addAttribute("userView", userRepository.findAll().toString());
//        return "authors";
//    }

    @RequestMapping("/users")
    public String getAuthors(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }





}
