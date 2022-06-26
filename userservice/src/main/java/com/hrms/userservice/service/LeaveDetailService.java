package com.hrms.userservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.userservice.domain.Employee;
import com.hrms.userservice.domain.LeaveDetail;

public interface LeaveDetailService {
    public LeaveDetail save(JsonNode json, Employee emp);
}
