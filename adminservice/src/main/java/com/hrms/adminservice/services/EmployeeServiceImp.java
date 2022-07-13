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

    @Autowired
    EmpLeaveService empLeaveService;

    @Override
    public Employee save(JsonNode emp) {
        Employee newEmp = new Employee();
        String name = emp.get("name").asText();
        String empCode = emp.get("empCode").asText();
        newEmp.setName(name);
        newEmp.setEmpCode(empCode);
        newEmp.setSSN(emp.get("ssn").asInt());
        newEmp.setMobile(emp.get("mobile").asInt());
        newEmp.setAlternateMobile(emp.get("alternateMobile").asInt());
        newEmp.setBirthDate(emp.get("birthDate").asText());
        newEmp.setMaritalStatus(emp.get("maritalStatus").asText());
        newEmp.setApproverCode(emp.get("approverCode").asText());
        // address save
        Address newAddress = addressServiceImp.save(emp.get("address"));
        if(newAddress == null) return null;
        newEmp.setAddress(newAddress);
        // user save
        User newUser = userServiceImp.save(name, emp.get("email").asText(), empCode);
        if(newUser == null) return null;
        newEmp.setEmailId(newUser.getId());
        // set default yearly leaves
        empLeaveService.setDefaultLeaves(empCode);
        // send Email
        emailService.sendEmail(newUser.getEmail(), "Your Company Log In Information", "Account: "+newUser.getName()+"\nEmail: "+newUser.getEmail()+"\nPassword: "+newUser.getPassword()+"\n");
        
        return employeeRepository.save(newEmp);
    }

    @Override
    public Employee findByEmailId(Long uId) {
        return employeeRepository.findByEmailId(uId);
    }

    @Override
    public Employee findByEmpCode(String empCode) {
        
        return employeeRepository.findByEmpCode(empCode);
    }
    
}
