package com.hrms.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.userservice.domain.Employee;
import com.hrms.userservice.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee findByEmailId(Long id) {
        return employeeRepository.findByEmailId(id);
    }
    
}
