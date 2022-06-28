package com.hrms.adminservice.services;

import com.hrms.adminservice.domain.EmpAttendance;

public interface EmpAttendanceService {
    public EmpAttendance createEmpAttendance(String empCode, String date, String attendance);
    
}
