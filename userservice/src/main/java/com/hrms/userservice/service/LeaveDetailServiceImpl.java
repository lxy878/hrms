package com.hrms.userservice.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.userservice.component.DataComponent;
import com.hrms.userservice.domain.Employee;
import com.hrms.userservice.domain.LeaveDetail;
import com.hrms.userservice.repository.LeaveDetailRepository;

@Service
public class LeaveDetailServiceImpl implements LeaveDetailService{

    @Autowired
    DataComponent dataComponent;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    LeaveDetailRepository leaveDetailRepository;

    @Override
    public LeaveDetail save(JsonNode json, Employee emp) {
        LeaveDetail newLeaveDetail = new LeaveDetail();
        String now = dataComponent.dateTimeToString(LocalDateTime.now(), "yyyy/MM/dd HH:mm:ss");
        newLeaveDetail.setAppliedDate(now);
        newLeaveDetail.setEmpCode(emp.getEmpCode());
        newLeaveDetail.setEmpName(emp.getName());
        newLeaveDetail.setFromDate(json.get("fromDate").asText());
        newLeaveDetail.setToDate(json.get("toDate").asText());
        newLeaveDetail.setDays(json.get("days").asDouble());
        newLeaveDetail.setLeaveType(json.get("leaveType").asText());
        newLeaveDetail.setStatus("Pending");
        newLeaveDetail.setContactNumber(json.get("contactNumber").asInt());
        newLeaveDetail.setReason(json.get("reason").asText());
        // other empName
        String processEmpCode = json.get("replacementName").asText();
        newLeaveDetail.setProcessCode(processEmpCode);
        String processName = employeeService.findByEmpCode(processEmpCode).getName();
        newLeaveDetail.setProcessName(processName);

        // reduce emp leave balance

        return leaveDetailRepository.save(newLeaveDetail);
    }
    
}
