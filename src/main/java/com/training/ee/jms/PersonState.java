package com.training.ee.cdi;

import com.training.ee.interceptor.NewAnnotation;
import com.training.ee.jms.EState;
import com.training.ee.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 * Created by yusufyazici on 14/02/2018.
 */

public class PersonState {

    private Person person;
    private String uid;
    private EState smsState = EState.PROCESSING;
    private EState dbState = EState.PROCESSING;
    private EState mailState = EState.PROCESSING;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public EState getSmsState() {
        return smsState;
    }

    public void setSmsState(EState smsState) {
        this.smsState = smsState;
    }

    public EState getDbState() {
        return dbState;
    }

    public void setDbState(EState dbState) {
        this.dbState = dbState;
    }

    public EState getMailState() {
        return mailState;
    }

    public void setMailState(EState mailState) {
        this.mailState = mailState;
    }
}
