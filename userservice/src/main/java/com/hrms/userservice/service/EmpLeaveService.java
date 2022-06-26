package com.hrms.userservice.service;

import java.util.List;

import com.hrms.userservice.domain.EmpLeave;

public interface EmpLeaveService {
    public List<EmpLeave> getEmpLeaves(String empCode);
    public EmpLeave updateEmpLeave(String empCode, String leaveType, double days);
}
