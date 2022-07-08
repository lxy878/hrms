package com.hrms.adminservice.services;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.adminservice.domain.ResignationDetail;

public interface ResignationDetailService {
    public List<ResignationDetail> findAllByApproverEmpCode(String approverEmpCode);
    public ResignationDetail update(JsonNode json);
}
