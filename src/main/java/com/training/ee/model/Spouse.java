package com.training.ee.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Spouse {
    
    @Id
    @GeneratedValue
    private long spouseId;

    private String spouseName;
    private String spouseSurname;
    private Date date;
    
    public String getSpouseName() {
        return spouseName;
    }
    
    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }
    
    public String getSpouseSurname() {
        return spouseSurname;
    }
    public void setSpouseSurname(String spouseSurname) {
        this.spouseSurname = spouseSurname;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
    
}
