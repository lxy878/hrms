package com.hrms.adminservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.adminservice.domain.Employee;
import com.hrms.adminservice.domain.ResignationAlert;
import com.hrms.adminservice.domain.ResignationDetail;
import com.hrms.adminservice.domain.ResignedEmp;
import com.hrms.adminservice.services.EmployeeService;
import com.hrms.adminservice.services.ResignationAlertService;
import com.hrms.adminservice.services.ResignationDetailService;
import com.hrms.adminservice.services.ResignedEmpService;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ResignationController {
    
    @Autowired
    ResignationDetailService resignationDetailService;
    
    @Autowired
    EmployeeService employeeService;

    @Autowired
    ResignedEmpService resignedEmpService;

    @Autowired
    ResignationAlertService resignationAlertService;

    @GetMapping("/getResignations/{uId}")
    private List<ResignationDetail> getResignations(@PathVariable Long uId){
        Employee emp = employeeService.findByEmailId(uId);
        return resignationDetailService.findAllByApproverEmpCode(emp.getEmpCode());
    }

    @PostMapping(value="/approveResignation")
    public ResignationDetail approveResignation(@RequestBody JsonNode json) {
        
        ResignationDetail detail = resignationDetailService.update(json);
        // save resigned emp info
        resignedEmpService.create(new ResignedEmp(detail.getEmpName(), detail.getEmpCode(), detail.getEmail(), detail.getMobile(), detail.getLandline(), detail.getAddress()));
        // create login check
        Employee emp = employeeService.findByEmpCode(detail.getEmpCode());
        resignationAlertService.create(new ResignationAlert(detail.getLastWorkingDate(), emp.getEmailId()));
        return detail;
    }
    
}
