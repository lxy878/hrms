package com.hrms.adminservice.services;

import java.util.List;
import java.util.Map;

import com.hrms.adminservice.domain.ResignationAlert;

public interface ResignationAlertService {
    public ResignationAlert create(ResignationAlert resignationAlert);
    public List<ResignationAlert> findAll();
    public Map<Long, String> deactivateAccounts();
}
