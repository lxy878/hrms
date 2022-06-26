package com.hrms.adminservice.services;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.adminservice.domain.LeaveDetail;

public interface LeaveDetailService {
    public List<LeaveDetail> getEmpLeaves();
    public LeaveDetail updateLeave(JsonNode json);
    
}
