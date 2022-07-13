package com.hrms.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.userservice.domain.Employee;
import com.hrms.userservice.service.EmployeeService;


@RestController
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getApprover/{uId}")
    private Employee getApprover(@PathVariable Long uId){
        Employee emp = employeeService.findByEmailId(uId);
        Employee approver = employeeService.findByEmpCode(emp.getApproverCode());
        return approver;
    }

    @GetMapping("/getEmployee/{uId}")
    private Employee getEmp(@PathVariable Long uId){
        return employeeService.findByEmailId(uId);
    }

}
