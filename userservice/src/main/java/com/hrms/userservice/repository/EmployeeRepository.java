package com.hrms.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.userservice.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    public Employee findByEmailId(Long id);
    public Employee findByEmpCode(String empCode);
}
