package com.hrms.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.userservice.domain.EmpLeave;

public interface EmpLeaveRepository extends JpaRepository<EmpLeave,Long>{
    
}
