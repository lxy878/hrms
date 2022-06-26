package com.hrms.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.userservice.domain.LeaveDetail;

public interface LeaveDetailRepository extends JpaRepository<LeaveDetail, Long>{
    
}
