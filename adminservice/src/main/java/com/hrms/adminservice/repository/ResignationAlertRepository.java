package com.hrms.adminservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.adminservice.domain.ResignationAlert;

public interface ResignationAlertRepository extends JpaRepository<ResignationAlert, Integer>{
    public List<ResignationAlert> findAll();
}
