package com.hrms.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.userservice.domain.Employee;
import com.hrms.userservice.domain.ResignationDetail;
import com.hrms.userservice.repository.ResignationDetailRepository;

@Service
public class ResignationDetailServiceImpl implements ResignationDetailService {

    @Autowired
    ResignationDetailRepository resignationDetailRepository;

    @Autowired
    EmployeeService employeeService;

    @Override
    public ResignationDetail save(JsonNode json) {
        ResignationDetail resignation = new ResignationDetail();
        
        // find emp by empcode
        Employee emp = employeeService.findByEmailId(json.get("uId").asLong());
        resignation.setEmpCode(emp.getEmpCode());
        resignation.setEmpName(emp.getName());
        resignation.setApproverEmpCode(emp.getApproverCode());
        
        resignation.setAppliedDate(json.get("appliedDate").asText());
        resignation.setLastWorkingDate(json.get("lastWorkingDate").asText());
        resignation.setNoticePeriodDate(json.get("noticePeriodDate").asText());
        resignation.setRecoveryDays(json.get("recoveryDays").asInt());
        resignation.setReason(json.get("reason").asText());
        resignation.setUserRemark(json.get("userRemark").asText());
        resignation.setEmail(json.get("email").asText());
        resignation.setMobile(json.get("mobile").asInt());
        resignation.setLandline(json.get("landline").asInt());
        resignation.setAddress(json.get("address").asText());

        resignation.setStatus("pending");
        resignation.setAction("pending");

        return resignationDetailRepository.save(resignation);
    }

   
}
