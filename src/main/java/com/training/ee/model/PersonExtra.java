package com.training.ee.model;

import javax.persistence.Embeddable;

@Embeddable
public class PersonExtra {
    private String extra1;
    private String extra2;


    public String getExtra1() {
        return extra1;
    }
    public void setExtra1(String extra1) {
        this.extra1 = extra1;
    }
    public String getExtra2() {
        return extra2;
    }
    public void setExtra2(String extra2) {
        this.extra2 = extra2;
    }
    
    
}
