package com.manchesterdigital.userservice.controller;

import com.manchesterdigital.userservice.entity.UserDTO;
import com.manchesterdigital.userservice.repository.UserRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
@Controller
public class LoginController {

    // login service Interface;
    // can map the below Gson like Image Service?
    // loginToSystem(User user);

    UserRepository userRepository;
    UserDTO thisUserDTO;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping({"", "/", "/login", "/login.html"})
    @ApiParam(defaultValue = "default", value = "This will do")
    public String loginForm(Model model){
        return "users/login";
    }

    @PostMapping("/added")
    public String loginSubmit(Model model, String username, String password){
        userRepository.findAll()
                .forEach(userDTO -> {
                    if (userDTO.getFirstName().equals(username)){
                        thisUserDTO = userDTO;
                    } else {
                        // throw exception? or go bck to not valid user.
                    }
                });
        if (thisUserDTO != null){
            model.addAttribute("user", thisUserDTO);
            return "users/added";
        } else {
            return "users/login";
        }

    }

}
