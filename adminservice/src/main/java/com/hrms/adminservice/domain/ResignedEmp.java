package com.hrms.adminservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ResignedEmp {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String empCode;
    private String email;
    private int mobile;
    private int landline;
    private String address;

    public ResignedEmp(){}
    
    public ResignedEmp(String name, String empCode, String email, int mobile, int landline, String address) {
        this.name = name;
        this.empCode = empCode;
        this.email = email;
        this.mobile = mobile;
        this.landline = landline;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public int getLandline() {
        return landline;
    }

    public void setLandline(int landline) {
        this.landline = landline;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
