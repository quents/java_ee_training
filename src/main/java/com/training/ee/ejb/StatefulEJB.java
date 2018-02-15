package com.training.ee.ejb;

import com.training.ee.model.Person;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import java.io.Serializable;

/**
 * Created by yusufyazici on 14/02/2018.
 */

//Design i hep Stateless la yapmak tavsiye ediliyor
//memory ile ilgili is yapilmak isteniyorsa Stateful yapilabilir

//Spring te stateless yok default olarak singleton, ya da stateful olabiliyor
@Stateful
@LocalBean
public class StatefulEJB implements Serializable { //byte array e cevrilebilmesini sagliyor

    @EJB
    private PersonDAO personDAO;

    public StatefulEJB(){

    }

    @PostConstruct
    public void init(){
        Person person = new Person();
        personDAO.save(person);
    }

    @PreDestroy
    public void destroy(){
        System.out.println("StatefulEJB destroyed");
    }

    //Diske yazılmayla ilgili ayarlar
    //Stateful hep memory de kalır
    @PrePassivate
    public void persistBefore(){

    }

    @PostActivate
    public void persistAfter(){

    }

    @Remove
    public void destroyEJB(){
        System.out.println("StatefulEJB remove");
    }
}
