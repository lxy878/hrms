package com.hrms.adminservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.adminservice.domain.ResignationAlert;
import com.hrms.adminservice.repository.ResignationAlertRepository;

@Service
public class ResignationAlertServiceImpl implements ResignationAlertService{
    @Autowired
    ResignationAlertRepository resignationAlertRepository;

    @Override
    public ResignationAlert create(ResignationAlert resignationAlert) {
        
        return resignationAlertRepository.save(resignationAlert);
    }
    
}
