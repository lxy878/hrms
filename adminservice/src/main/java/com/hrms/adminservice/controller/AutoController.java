package com.hrms.adminservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.adminservice.services.CheckService;

@RestController
public class AutoController {
    
    @Autowired
    CheckService checkService;

    @GetMapping("/checkLeaves/{uId}")
    private Map<String, String> checkLeaves(@PathVariable Long uId){
        Map<String, String> respond = new HashMap<>();
        respond.put("Message", checkService.leaveCheck(uId));
        return respond;
    }
}
