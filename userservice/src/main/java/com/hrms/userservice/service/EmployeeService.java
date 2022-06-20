package com.hrms.userservice.service;

import com.hrms.userservice.domain.Employee;

public interface EmployeeService {
    public Employee findByEmailId(Long id);
}
