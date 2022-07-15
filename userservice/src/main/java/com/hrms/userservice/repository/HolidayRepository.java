package com.hrms.userservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.userservice.domain.Holiday;

public interface HolidayRepository extends JpaRepository<Holiday, Integer>{
    
    public List<Holiday> findTop3ByDateAfter(String date);
    
}
