package com.hrms.adminservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.adminservice.domain.LeaveDetail;
import com.hrms.adminservice.repository.LeaveDetailRepository;

@Service
public class LeaveDetailServiceImpl implements LeaveDetailService{

    @Autowired
    LeaveDetailRepository leaveDetailRepository;

    @Override
    public List<LeaveDetail> getEmpLeaves() {
        return leaveDetailRepository.findAll();
    }

    @Override
    public LeaveDetail updateLeave(JsonNode json) {
        
        // leaveId
        leaveDetailRepository.findById((long)1).get();
        // updates
        json.get("action").asText();
        json.get("approverCode").asText();
        json.get("approverName");
        // change status as action
        // find empLeave by empCode and type
        // update empLeave
        // save
        return null;
    }
    
}
