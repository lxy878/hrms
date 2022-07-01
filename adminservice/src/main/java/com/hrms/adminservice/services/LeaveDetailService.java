package com.hrms.adminservice.services;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.adminservice.domain.LeaveDetail;

public interface LeaveDetailService {
    public List<LeaveDetail> getEmpLeaves(String approverCode);
    public LeaveDetail updateLeave(JsonNode json);
    public List<LeaveDetail> findAllOrderByAppliedDate(String empCode, String status);
    
}
