package com.hrms.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.userservice.domain.EmpAttendance;

public interface EmpAttendanceRepository extends JpaRepository<EmpAttendance, Long>{
    public EmpAttendance findByEmpCodeAndAttendanceDate(String empCode, String attendanceDate);
    public List<EmpAttendance> findAllByEmpCode(String EmpCode);
}
