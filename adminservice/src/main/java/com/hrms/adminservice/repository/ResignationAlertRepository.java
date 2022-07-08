package com.hrms.adminservice.repository;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.adminservice.domain.ResignationAlert;

public interface ResignationAlertRepository extends JpaRepository<ResignationAlert, Integer>{
    
}
