package com.hrms.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.adminservice.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    
}
