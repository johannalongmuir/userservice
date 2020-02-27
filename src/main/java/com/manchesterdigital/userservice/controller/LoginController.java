package com.manchesterdigital.userservice.controller;

import com.manchesterdigital.userservice.entity.UserDTO;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

//@RequestMapping("/login")
@Controller
public class LoginController {

    //login service Interface;
    // can map the below Gson like Image Service?
    // loginToSystem(User user);

    @PostMapping({"", "/", "login", "login.html"})
    @ApiParam(defaultValue = "default", value = "This will do")
    public String login(Model model, UserDTO userDTO){
        return "users/login";
    }

}
