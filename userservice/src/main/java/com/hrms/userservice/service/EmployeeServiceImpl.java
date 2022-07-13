package com.hrms.userservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.userservice.domain.Address;
import com.hrms.userservice.domain.Employee;
import com.hrms.userservice.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    AddressService addressService;

    @Override
    public Employee findByEmailId(Long id) {
        return employeeRepository.findByEmailId(id);
    }

    @Override
    public Employee findByEmpCode(String empCode) {
        
        return employeeRepository.findByEmpCode(empCode);
    }
    
    @Override
    public Employee update(JsonNode json){
        
        Optional<Employee> e = employeeRepository.findById(json.get("id").asLong());
        if(!e.isPresent()) return null;

        Employee emp = e.get();
        String name = json.get("name").asText();
        String empCode = json.get("empCode").asText();
        emp.setName(name);
        emp.setEmpCode(empCode);
        emp.setSSN(json.get("ssn").asInt());
        emp.setMobile(json.get("mobile").asInt());
        emp.setAlternateMobile(json.get("alternateMobile").asInt());
        emp.setBirthDate(json.get("birthDate").asText());
        emp.setMaritalStatus(json.get("maritalStatus").asText());
        emp.setApproverCode(json.get("approverCode").asText());
        
        // update address 
        Address addr = addressService.update(json.get("address"));
        if(addr == null) return null;
        emp.setAddress(addr);

        // if update email, update user
        
        return employeeRepository.save(emp);
    }
}
