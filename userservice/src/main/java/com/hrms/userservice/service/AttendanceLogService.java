package com.hrms.userservice.service;

import org.springframework.stereotype.Service;

import com.hrms.userservice.domain.AttendanceLog;

@Service
public interface AttendanceLogService {
    public AttendanceLog logIn(String empCode);
    public AttendanceLog logOut(String empCode);
}
