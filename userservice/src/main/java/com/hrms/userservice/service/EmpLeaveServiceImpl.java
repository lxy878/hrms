package com.hrms.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.userservice.domain.EmpLeave;
import com.hrms.userservice.repository.EmpLeaveRepository;

@Service
public class EmpLeaveServiceImpl implements EmpLeaveService{
    @Autowired
    EmpLeaveRepository empLeaveRepository;

    @Override
    public List<EmpLeave> getEmpLeaves(String empCode){
        return empLeaveRepository.findAllByEmpCode(empCode);
    }
}
