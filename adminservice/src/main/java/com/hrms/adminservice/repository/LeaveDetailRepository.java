package com.hrms.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.adminservice.domain.LeaveDetail;

public interface LeaveDetailRepository extends JpaRepository<LeaveDetail, Long>{
    
}
