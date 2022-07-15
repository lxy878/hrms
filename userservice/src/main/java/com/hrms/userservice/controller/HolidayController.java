package com.hrms.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.userservice.domain.Holiday;
import com.hrms.userservice.service.HolidayService;

@RestController
public class HolidayController {
    
    @Autowired
    HolidayService holidayService;

    @GetMapping("/getTop3Holodays")
    private List<Holiday> getTop3Holiday(){
        return holidayService.getHolidayByDate();
    }
}
