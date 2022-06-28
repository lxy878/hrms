package com.hrms.userservice.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.userservice.component.DateComponent;
import com.hrms.userservice.domain.AttendanceLog;
import com.hrms.userservice.domain.EmpAttendance;
import com.hrms.userservice.repository.AttendanceLogRepository;

@Service
public class AttendanceLogServiceImpl implements AttendanceLogService{
    @Autowired
    AttendanceLogRepository log;

    @Autowired
    EmpAttendanceService empAttendanceService;

    @Autowired
    DateComponent dateComponent;

    @Override
    public AttendanceLog logIn(String empCode) {
        String dateTime = dateTimeToString(LocalDateTime.now(), "yyyy/MM/dd HH:mm:ss");
        String newFormTime = dateComponent.changeDateForm(dateTime, "yyyy/MM/dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss");
        AttendanceLog aLog = new AttendanceLog();
        aLog.setEmpCode(empCode);
        aLog.setLogDate(newFormTime);
        aLog.setLogType("IN");

        EmpAttendance empAtt = empAttendanceService.empAttendanceForLogIn(empCode, newFormTime);
        if(empAtt == null) return null;

        return log.save(aLog);
        
    }
    
    @Override
    public AttendanceLog logOut(String empCode) {
        String dateTime = dateTimeToString(LocalDateTime.now(), "yyyy/MM/dd HH:mm:ss");
        String newFormTime = dateComponent.changeDateForm(dateTime, "yyyy/MM/dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss");
        AttendanceLog aLog = new AttendanceLog();
        aLog.setEmpCode(empCode);
        aLog.setLogDate(newFormTime);
        aLog.setLogType("OUT");

        EmpAttendance empAtt = empAttendanceService.empAttendanceForLogOut(empCode, newFormTime);
        if(empAtt == null) return null;

        return log.save(aLog);
    }

    // replace
    private String dateTimeToString(LocalDateTime ldt, String pattern){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return dtf.format(ldt);
    }
    
}
