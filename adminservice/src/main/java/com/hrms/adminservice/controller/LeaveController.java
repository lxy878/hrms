package com.hrms.adminservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.adminservice.domain.Employee;
import com.hrms.adminservice.domain.LeaveDetail;
import com.hrms.adminservice.services.EmployeeService;
import com.hrms.adminservice.services.LeaveDetailService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class LeaveController {
    
    @Autowired
    LeaveDetailService leaveDetailService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getEmpLeaves/{uId}")
    private List<LeaveDetail> getEmpLeaves(@PathVariable Long uId) {
        Employee emp = employeeService.findByEmailId(uId);
        return leaveDetailService.getEmpLeaves(emp.getEmpCode());
    }
    
    @PostMapping("/updateLeave")
    private LeaveDetail updateLeave(@RequestBody JsonNode json){
        return leaveDetailService.updateLeave(json);
    } 
}
