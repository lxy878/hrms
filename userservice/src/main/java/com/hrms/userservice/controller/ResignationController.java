package com.hrms.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.userservice.domain.ResignationDetail;
import com.hrms.userservice.service.ResignationDetailService;

@RestController
public class ResignationController {
    
    @Autowired
    ResignationDetailService resignationDetailService;
    
    @PostMapping("/submitResignation")
    private ResignationDetail submit(@RequestBody JsonNode json){
        return resignationDetailService.save(json);
    }
}
