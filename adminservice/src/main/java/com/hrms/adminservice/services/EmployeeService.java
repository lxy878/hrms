package com.hrms.adminservice.services;
import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.adminservice.domain.Employee;

public interface EmployeeService {
    public Employee save(JsonNode emp);
    public Employee findByEmailId(Long uId);
}
