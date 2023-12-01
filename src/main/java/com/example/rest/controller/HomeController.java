package com.example.rest.controller;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/")
public class HomeController {
    public String index() {
        return "index";
    }
    
}

