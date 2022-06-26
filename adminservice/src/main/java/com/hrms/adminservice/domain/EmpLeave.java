package com.hrms.adminservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmpLeave {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String leaveType;
    private String empCode;
    // leaves for a year
    private int yearlyAllowance;
    // remainding leaves
    private double leaveBalance;
    // const leaves 
    private double openBalance;
    // approved leaves
    private double leaveApplied;
    
    public double getLeaveApplied() {
        return leaveApplied;
    }

    public void setLeaveApplied(double leaveApplied) {
        this.leaveApplied = leaveApplied;
    }

    public double getOpenBalance() {
        return openBalance;
    }

    public void setOpenBalance(Double openBalance) {
        this.openBalance = openBalance;
    }

    public double getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(Double leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    public int getYearlyAllowance() {
        return yearlyAllowance;
    }

    public void setYearlyAllowance(int yearlyAllowance) {
        this.yearlyAllowance = yearlyAllowance;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
