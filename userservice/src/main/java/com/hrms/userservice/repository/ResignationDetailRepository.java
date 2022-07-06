package com.hrms.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.userservice.domain.ResignationDetail;

public interface ResignationDetailRepository extends JpaRepository<ResignationDetail, Long>{
    
}
