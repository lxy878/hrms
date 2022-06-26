package com.hrms.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.adminservice.domain.EmpLeave;

public interface EmpLeaveRepository extends JpaRepository<EmpLeave,Long>{
    public EmpLeave findByEmpCodeAndLeaveType(String empCode, String leaveType);
}
