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

    @Override
    public EmpLeave updateEmpLeave(String empCode, String leaveType, double days){
        EmpLeave leave = empLeaveRepository.findByEmpCodeAndLeaveType(empCode, leaveType);
        leave.setLeaveBalance(leave.getLeaveBalance()-days);
        return empLeaveRepository.save(leave);
    }
}
