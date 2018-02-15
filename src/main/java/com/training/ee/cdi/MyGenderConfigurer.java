package com.training.ee.cdi;

import com.training.ee.ejb.PersonDAO;
import com.training.ee.model.Person;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by yusufyazici on 14/02/2018.
 */
public class MyGenderConfigurer {

    @Produces
    @Named("genderConfigurer")
    @RequestScoped
    public IProcessGender createProcessGender(PersonHolder personHolder){

        Person person = personHolder.getPerson();
        if (person == null){
            return null;
        }
        if (person.getCinsiyet().equalsIgnoreCase("erkek")){
            return new BayProcess();
        }
        else {
            return new BayanProcess();
        }

    }
}
