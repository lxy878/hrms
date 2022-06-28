package com.hrms.adminservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.adminservice.domain.EmpAttendance;
import com.hrms.adminservice.repository.EmpAttendanceRepository;

@Service
public class EmpAttendanceServiceImpl implements EmpAttendanceService{

    @Autowired
    EmpAttendanceRepository empAttendanceRepository;

    public EmpAttendance createEmpAttendance(String empCode, String date, String attendance){
        EmpAttendance att = new EmpAttendance();
        att.setEmpCode(empCode);
        att.setAttendanceDate(date);
        att.setAttendance(attendance);
        return empAttendanceRepository.save(att);
    }
}
