package com.hrms.userservice.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.userservice.domain.AttendanceLog;
import com.hrms.userservice.repository.AttendanceLogRepository;

@Service
public class AttendanceLogServiceImpl implements AttendanceLogService{
    @Autowired
    AttendanceLogRepository log;

    @Override
    public AttendanceLog logIn(String empCode) {
        String date = dateTimeToString(LocalDateTime.now(), "yyyy/MM/dd HH:mm:ss");
        AttendanceLog aLog = new AttendanceLog();
        aLog.setEmpCode(empCode);
        aLog.setLogDate(date);
        aLog.setLogType("IN");
        return log.save(aLog);
        
    }
    
    @Override
    public AttendanceLog logOut(String empCode) {
        String date = dateTimeToString(LocalDateTime.now(), "yyyy/MM/dd HH:mm:ss");
        AttendanceLog aLog = new AttendanceLog();
        aLog.setEmpCode(empCode);
        aLog.setLogDate(date);
        aLog.setLogType("OUT");
        return log.save(aLog);
    }

    private LocalDateTime stringToDateTime(String dt, String pattern){

        return null;
    }

    private String dateTimeToString(LocalDateTime ldt, String pattern){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(ldt);
    }
    
}
