package com.hrms.userservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.userservice.domain.ResignationDetail;

public interface ResignationDetailService {
    public ResignationDetail save(JsonNode json);
}
