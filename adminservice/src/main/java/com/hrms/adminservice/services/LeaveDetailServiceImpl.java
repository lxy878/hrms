package com.hrms.adminservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.adminservice.domain.Employee;
import com.hrms.adminservice.domain.LeaveDetail;
import com.hrms.adminservice.repository.LeaveDetailRepository;

@Service
public class LeaveDetailServiceImpl implements LeaveDetailService{

    @Autowired
    LeaveDetailRepository leaveDetailRepository;

    @Autowired
    EmployeeService employeeService;

    @Override
    public List<LeaveDetail> getEmpLeaves() {
        return leaveDetailRepository.findAll();
    }

    @Override
    public LeaveDetail updateLeave(JsonNode json) {
        
        // leaveId
        Long leaveId = json.get("leaveId").asLong();
        LeaveDetail ld = leaveDetailRepository.findById(leaveId).get();
        ld.setAction(json.get("action").asText());
        System.out.println(json.get("approverCode").asLong());
        Employee approver = employeeService.findByEmailId(json.get("approverCode").asLong());
        ld.setApproverCode(approver.getEmpCode());
        ld.setApproverName(approver.getName());
        ld.setStatus(json.get("status").asText());

        
        // find empLeave by empCode and type
        
        // update empLeave
        // save
        return leaveDetailRepository.save(ld);
    }
    
}
