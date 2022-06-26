package com.hrms.adminservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.adminservice.domain.LeaveDetail;
import com.hrms.adminservice.services.LeaveDetailService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class LeaveController {
    
    @Autowired
    LeaveDetailService leaveDetailService;

    @GetMapping("/getEmpLeaves")
    private List<LeaveDetail> getEmpLeaves() {
        return leaveDetailService.getEmpLeaves();
    }
    
    @PostMapping("/updateLeave")
    private LeaveDetail updateLeave(@RequestBody JsonNode json){
        return leaveDetailService.updateLeave(json);
    } 
}
