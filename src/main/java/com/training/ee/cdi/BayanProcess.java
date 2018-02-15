package com.training.ee.cdi;

import com.training.ee.model.Person;

import javax.enterprise.inject.Any;
import java.io.Serializable;

/**
 * Created by yusufyazici on 14/02/2018.
 */
@Any
public class BayanProcess implements IProcessGender, Serializable {

    public String processGender(Person person) {
        return "Bayan " + person.getIsim();
    }
}
