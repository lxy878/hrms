package com.hrms.adminservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.adminservice.domain.LeaveDetail;

public interface LeaveDetailRepository extends JpaRepository<LeaveDetail, Long>{
    public List<LeaveDetail> findAll();
}
