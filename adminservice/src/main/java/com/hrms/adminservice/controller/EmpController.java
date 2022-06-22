package com.hrms.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.adminservice.domain.Employee;
import com.hrms.adminservice.services.EmployeeService;

@RestController
public class EmpController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/saveEmp")
    private Employee saveEmp(@RequestBody JsonNode emp){
        return employeeService.save(emp);
    }
}

