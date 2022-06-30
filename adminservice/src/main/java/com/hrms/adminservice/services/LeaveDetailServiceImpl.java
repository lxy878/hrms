package com.hrms.adminservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.adminservice.component.DateComponent;
import com.hrms.adminservice.domain.Employee;
import com.hrms.adminservice.domain.LeaveDetail;
import com.hrms.adminservice.repository.LeaveDetailRepository;

@Service
public class LeaveDetailServiceImpl implements LeaveDetailService{

    @Autowired
    LeaveDetailRepository leaveDetailRepository;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmpLeaveService empLeaveService;

    @Autowired
    DateComponent dateComponent;

    @Autowired
    EmpAttendanceService empAttendanceService;
    
    @Override
    public List<LeaveDetail> getEmpLeaves(String approverCode) {
        return leaveDetailRepository.findAllByApproverCode(approverCode);
    }

    @Override
    public LeaveDetail updateLeave(JsonNode json) {
        
        // leaveId
        Long leaveId = json.get("leaveId").asLong();
        LeaveDetail ld = leaveDetailRepository.findById(leaveId).get();
        ld.setAction(json.get("action").asText());
        System.out.println(json.get("approverCode").asLong());
        Employee approver = employeeService.findByEmailId(json.get("approverCode").asLong());
        ld.setApproverCode(approver.getEmpCode());
        ld.setApproverName(approver.getName());
        ld.setStatus(json.get("status").asText());

        // update empLeave
        empLeaveService.updateEmpLeave(ld.getEmpCode(), ld.getLeaveType(), ld.getDays(), ld.getAction());

        // create attendances with leaves
        long td = dateComponent.stringToDate(ld.getToDate(), "yyyy-MM-dd").getTime();
        long fd = dateComponent.stringToDate(ld.getFromDate(), "yyyy-MM-dd").getTime();
        int days = dateComponent.getDays(fd, td);
        if(days==ld.getDays()){
            // create attendance 
            String date = ld.getFromDate();
            for(int i=0; i<days; i++){
                empAttendanceService.createEmpAttendance(ld.getEmpCode(), date, "leave");
                date = dateComponent.incrementDay(date, 1);
            }
        }
        // save
        return leaveDetailRepository.save(ld);
    }

    
    
}
