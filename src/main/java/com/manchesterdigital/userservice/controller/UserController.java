package com.manchesterdigital.userservice.controller;

import com.manchesterdigital.userservice.entity.UserDTO;
import com.manchesterdigital.userservice.repository.UserRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping({"", "/", "index", "index.html"})
    @ApiParam(defaultValue = "default", value = "This will do")
    public String listAllUsers(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "users/index";
    }

    @PostMapping(value = {"create", "create/"})
    public String createNewUser(Model model, @RequestBody  UserDTO userDTO){
        model.addAttribute("user", userRepository.save(userDTO));
        return "users/added";
    }



}
