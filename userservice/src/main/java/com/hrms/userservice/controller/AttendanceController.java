package com.hrms.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrms.userservice.domain.AttendanceLog;
import com.hrms.userservice.domain.EmpAttendance;
import com.hrms.userservice.domain.Employee;
import com.hrms.userservice.service.AttendanceLogService;
import com.hrms.userservice.service.EmpAttendanceService;
import com.hrms.userservice.service.EmployeeService;

@RestController
public class AttendanceController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    AttendanceLogService attendanceLogService;

    @Autowired
    EmpAttendanceService empAttendanceService;
    // fix to id

    @PostMapping("/empLogin")
    private JsonNode empLogin(@RequestBody JsonNode json){
        Long id = json.get("uId").asLong();
        Employee emp = employeeService.findByEmailId(id);
        String empCode = emp.getEmpCode();
        AttendanceLog alog = attendanceLogService.logIn(empCode);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(alog, JsonNode.class);
    }

    @PostMapping("/empLogout")
    private JsonNode empLogout(@RequestBody JsonNode json){
        Long id = json.get("uId").asLong();
        Employee emp = employeeService.findByEmailId(id);
        String empCode = emp.getEmpCode();
        AttendanceLog alog = attendanceLogService.logOut(empCode);


        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(alog, JsonNode.class);
    }
    
}
