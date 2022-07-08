package com.hrms.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.adminservice.domain.ResignedEmp;

public interface ResignedEmpRepository extends JpaRepository<ResignedEmp, Long>{
    
}
