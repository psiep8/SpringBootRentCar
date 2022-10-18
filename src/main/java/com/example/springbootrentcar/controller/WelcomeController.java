package com.example.springbootrentcar.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
//@CrossOrigin("http://localhost:4200")
public class WelcomeController {

    @GetMapping()
    public String welcome() {
        return "\"Welcome to my websiteeeeee\"";
    }
}
