package com.hrms.gateservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hrms.gateservice.domain.User;
import com.hrms.gateservice.restclients.AdminClient;
import com.hrms.gateservice.services.UserService;

@Controller
public class AdminViewController {

    @Autowired
    AdminClient adminClient;

    @Autowired
    UserService userService;
    
    @GetMapping("/admin")
    private String getAdmin(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
        User user = userService.findByName(userName);
        model.addAttribute("uId", user.getId());
        return "homeAdmin";
    }

    @GetMapping("/admin/register")
    private String getRegister(){
        return "register";
    }

    @GetMapping("/admin/empLeaves")
    private String getEmpLeaves(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
        User user = userService.findByName(userName);
        model.addAttribute("uId", user.getId());
        return "leaveAdmin";
    }

    @GetMapping("/admin/resignationApprove/{uId}")
    private String resignationApprove(@PathVariable Long uId, Model model){
        model.addAttribute("uId", uId);
        return "resignationAdmin";
    }
    
}
