package com.hrms.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.userservice.domain.AttendanceLog;

public interface AttendanceLogRepository extends JpaRepository<AttendanceLog, Long>{
    public AttendanceLog findByEmpCode(String empCode);
}
