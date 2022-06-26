package com.hrms.adminservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.adminservice.domain.EmpLeave;
import com.hrms.adminservice.repository.EmpLeaveRepository;

@Service
public class EmpLeaveServiceImpl implements EmpLeaveService{
    
    @Autowired
    EmpLeaveRepository empLeaveRepository;

    @Override
    public void setDefaultLeaves(String empCode){
        setLeave(empCode, "PL");
        setLeave(empCode, "PH");
    }

    private EmpLeave setLeave(String empCode, String leaveType){
        EmpLeave leave = new EmpLeave();
        leave.setLeaveType(leaveType);
        leave.setEmpCode(empCode);

        leave.setYearlyAllowance(20);
        leave.setOpenBalance(20.0);

        leave.setLeaveBalance(20.0);
        leave.setLeaveApplied(0.0);
        return empLeaveRepository.save(leave);
    }
}
