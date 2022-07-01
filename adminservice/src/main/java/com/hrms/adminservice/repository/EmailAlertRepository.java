package com.hrms.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.adminservice.domain.EmailAlert;

public interface EmailAlertRepository extends JpaRepository<EmailAlert, Long>{
    public EmailAlert findByUserIdAndCheckDate(Long uId, String checkDate);
}
