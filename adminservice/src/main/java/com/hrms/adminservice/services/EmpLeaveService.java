package com.hrms.adminservice.services;

import com.hrms.adminservice.domain.EmpLeave;

public interface EmpLeaveService {
    public void setDefaultLeaves(String empCode);
    public EmpLeave updateEmpLeave(String empCode, String leaveType, double days, String action);
}
