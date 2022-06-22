package com.hrms.adminservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.adminservice.domain.Address;
import com.hrms.adminservice.domain.Employee;
import com.hrms.adminservice.domain.User;
import com.hrms.adminservice.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    UserServiceImp userServiceImp;

    @Autowired
    AddressServiceImp addressServiceImp;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmailService emailService;

    @Override
    public Employee save(JsonNode emp) {
        Employee newEmp = new Employee();
        String name = emp.get("name").asText();
        String empCode = emp.get("empCode").asText();
        newEmp.setName(name);
        newEmp.setEmpCode(empCode);
        newEmp.setSSN(emp.get("ssn").asInt());
        newEmp.setAlternateMobile(emp.get("alternateMobile").asInt());
        newEmp.setBirthDate(emp.get("birthDate").asText());
        newEmp.setMaritalStatus(emp.get("maritalStatus").asText());
        // address save
        Address newAddress = addressServiceImp.save(emp.get("address"));
        if(newAddress == null) return null;
        newEmp.setAddress(newAddress);
        // user save
        User newUser = userServiceImp.save(name, emp.get("email").asText(), empCode);
        if(newUser == null) return null;
        newEmp.setEmailId(newUser.getId());
        // send Email
        emailService.sendEmail(newUser);
        
        return employeeRepository.save(newEmp);
    }
    
}
