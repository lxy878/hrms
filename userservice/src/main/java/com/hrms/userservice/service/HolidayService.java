package com.hrms.userservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.userservice.component.DateComponent;
import com.hrms.userservice.domain.Holiday;
import com.hrms.userservice.repository.HolidayRepository;

@Service
public class HolidayService {
    
    @Autowired
    HolidayRepository holidayRepository;

    @Autowired
    DateComponent dateComponent;

    public List<Holiday> getHolidayByDate(){
        String today =dateComponent.dateTimeToString(LocalDateTime.now(), "MM-dd");
        
        return holidayRepository.findTop3ByDateAfter(today);

    }
}
