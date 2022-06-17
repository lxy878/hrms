package com.hrms.gateservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/forAdmin")
    private String getAdmin(){
        return "homeAdmit";
    }

    @GetMapping("/admin/register")
    private String getRegister(){
        return "register";
    }
}
