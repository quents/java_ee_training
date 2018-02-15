package com.training.ee.cdi;

import com.training.ee.model.Person;

import javax.enterprise.inject.Default;
import java.io.Serializable;

/**
 * Created by yusufyazici on 14/02/2018.
 */
@Default
public class BayProcess implements IProcessGender, Serializable {

    public String processGender(Person person) {
        return "Bay " + person.getIsim();
    }
}
