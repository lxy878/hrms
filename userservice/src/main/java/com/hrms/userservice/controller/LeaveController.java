package com.hrms.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.userservice.domain.EmpLeave;
import com.hrms.userservice.domain.Employee;
import com.hrms.userservice.domain.LeaveDetail;
import com.hrms.userservice.service.EmpLeaveService;
import com.hrms.userservice.service.EmployeeService;
import com.hrms.userservice.service.LeaveDetailService;

@RestController
public class LeaveController {
    
    @Autowired
    LeaveDetailService leaveDetailService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmpLeaveService empLeaveService;

    @PostMapping("/submitLeave")
    private LeaveDetail submitLeave(@RequestBody JsonNode json){
        Employee emp = employeeService.findByEmailId(json.get("uId").asLong());

        return leaveDetailService.save(json, emp);
    }

    @GetMapping("/getLeaves/{uId}")
    private List<EmpLeave> getLeaves(@PathVariable Long uId){
        String empCode = employeeService.findByEmailId(uId).getEmpCode();
        return empLeaveService.getEmpLeaves(empCode);
    }
}   
