package com.hrms.adminservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.adminservice.domain.ResignedEmp;
import com.hrms.adminservice.repository.ResignedEmpRepository;

@Service
public class ResignedEmpServiceImpl implements ResignedEmpService{
    @Autowired
    ResignedEmpRepository resignedEmpRepository;

    @Override
    public ResignedEmp create(ResignedEmp emp) {
        return resignedEmpRepository.save(emp);
    }
    
}
