package com.hrms.userservice.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.userservice.domain.Employee;

public interface EmployeeService {
    public Employee findByEmailId(Long id);
    public Employee findByEmpCode(String empCode);
    public Employee update(JsonNode json);
    public List<Employee> getEmployeesByBirthday();
}
