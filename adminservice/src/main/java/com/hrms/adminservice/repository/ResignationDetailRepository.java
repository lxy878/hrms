package com.hrms.adminservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.adminservice.domain.ResignationDetail;

public interface ResignationDetailRepository extends JpaRepository<ResignationDetail, Long>{
    public List<ResignationDetail> findAllByApproverEmpCode(String approverEmpCode);
    public Optional<ResignationDetail> findById(Long id);
    
}