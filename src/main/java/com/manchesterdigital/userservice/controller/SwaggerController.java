package com.manchesterdigital.userservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/swagger")
@Controller
public class SwaggerController {

    // redirects to ui for swagger
    @GetMapping
    public String swaggerUi() {
        return "redirect:/swagger-ui.html";
    }

}
