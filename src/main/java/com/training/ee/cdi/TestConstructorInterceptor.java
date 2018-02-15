package com.training.ee.cdi;

import com.training.ee.interceptor.NewAnnotation;
import com.training.ee.model.Person;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 * Created by yusufyazici on 14/02/2018.
 */
@NewAnnotation
public class TestConstructorInterceptor implements Serializable {

    private Person person;
    private String id;

//    public PersonHolder(PersonHolder holder) {
//        this.person = holder.getPerson();
//        this.id = holder.getId();
//    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
