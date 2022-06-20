package com.hrms.userservice.service;

import com.hrms.userservice.domain.EmpAttendance;

public interface EmpAttendanceService {
    public EmpAttendance empAttendanceForLogIn(String empCode, String dateTime);
    public EmpAttendance empAttendanceForLogOut(String empCode, String dateTime);
    
}
