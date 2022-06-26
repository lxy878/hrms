package com.hrms.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.userservice.domain.Employee;
import com.hrms.userservice.domain.LeaveDetail;
import com.hrms.userservice.service.EmployeeService;
import com.hrms.userservice.service.LeaveDetailService;

@RestController
public class LeaveController {
    
    @Autowired
    LeaveDetailService leaveDetailService;

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/submitLeave")
    private LeaveDetail submitLeave(@RequestBody JsonNode json){
        Employee emp = employeeService.findByEmailId(json.get("uId").asLong());

        return leaveDetailService.save(json, emp);
    }
}   
