package com.hrms.adminservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ResignationAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastWorkingDate;
    private Long uId;

    public ResignationAlert(String lastWorkingDate, Long uId) {
        this.lastWorkingDate = lastWorkingDate;
        this.uId = uId;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLastWorkingDate() {
        return lastWorkingDate;
    }
    public void setLastWorkingDate(String lastWorkingDate) {
        this.lastWorkingDate = lastWorkingDate;
    }
    public Long getuId() {
        return uId;
    }
    public void setuId(Long uId) {
        this.uId = uId;
    }

    
}
