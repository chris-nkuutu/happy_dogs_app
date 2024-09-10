package com.example.happy_dogs_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/") //->http:localhost:8080/
    public String getHomePage() {

        System.out.println("There we Land");

        return "home";
    }
}
