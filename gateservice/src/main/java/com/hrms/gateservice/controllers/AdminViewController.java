package com.hrms.gateservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.hrms.gateservice.restclients.AdminClient;

@Controller
public class AdminViewController {

    @Autowired
    AdminClient adminClient;

    @GetMapping("/admin")
    private String getAdmin(){
        return "homeAdmit";
    }

    @GetMapping("/admin/register")
    private String getRegister(){
        return "register";
    }
}
