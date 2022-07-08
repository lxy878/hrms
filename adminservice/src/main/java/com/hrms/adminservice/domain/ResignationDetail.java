package com.hrms.adminservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ResignationDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empCode;
    private String empName;
    private String appliedDate;
    private String lastWorkingDate;
    // date resignation submited
    private String noticePeriodDate;
    // last working - resignation applied
    private int recoveryDays;
    private String reason;
    private String userRemark;
    // personal Details
    private String email;
    private int mobile;
    private int landline;
    private String address;

    // pending
    private String status;
    // approve
    private String action;
    
    private String approverEmpCode;

    public String getApproverEmpCode() {
        return approverEmpCode;
    }

    public void setApproverEmpCode(String approverEmpCode) {
        this.approverEmpCode = approverEmpCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLandline() {
        return landline;
    }

    public void setLandline(int landline) {
        this.landline = landline;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getRecoveryDays() {
        return recoveryDays;
    }

    public void setRecoveryDays(int recoveryDays) {
        this.recoveryDays = recoveryDays;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getNoticePeriodDate() {
        return noticePeriodDate;
    }

    public void setNoticePeriodDate(String noticePeriodDate) {
        this.noticePeriodDate = noticePeriodDate;
    }

    public String getLastWorkingDate() {
        return lastWorkingDate;
    }

    public void setLastWorkingDate(String lastWorkingDate) {
        this.lastWorkingDate = lastWorkingDate;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    
}
