package com.hrms.adminservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.adminservice.domain.ResignationDetail;
import com.hrms.adminservice.repository.ResignationDetailRepository;

@Service
public class ResignationDetailServiceImpl implements ResignationDetailService {

    @Autowired
    ResignationDetailRepository resignationDetailRepository;

    @Autowired
    EmployeeService employeeService;

    @Override
    public List<ResignationDetail> findAllByApproverEmpCode(String approverEmpCode) {
        return resignationDetailRepository.findAllByApproverEmpCode(approverEmpCode);
    }

    @Override
    public ResignationDetail update(JsonNode json){
        ResignationDetail detail = resignationDetailRepository.findById(json.get("resignationId").asLong()).get();
        detail.setLastWorkingDate(json.get("lastWorkingDate").asText());
        detail.setRecoveryDays(json.get("recoveryDays").asInt());
        detail.setAction("Approved");
        detail.setStatus("Approved");
        return resignationDetailRepository.save(detail);
    }
   
}
