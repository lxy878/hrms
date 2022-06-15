package com.hrms.gateservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    
    @GetMapping({"/", "/index","/home"})
    private String getIndex(){
        return "home";
    }

    @GetMapping("/forAdmin")
    private String getAdmin(){
        return "register";
    }
}
