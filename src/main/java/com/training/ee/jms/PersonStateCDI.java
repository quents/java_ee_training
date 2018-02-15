package com.training.ee.jms;

import com.training.ee.cdi.PersonState;
import com.training.ee.model.Person;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yusufyazici on 15/02/2018.
 */
@ApplicationScoped
public class PersonStateCDI {

    private Map<String, PersonState> personStateMap = new HashMap<String, PersonState>();

    public void setMapWithUid(String uid, PersonState personState){
        personStateMap.put(uid, personState);
    }

    public PersonState getPersonStateWithUid(String uid){
        return personStateMap.get(uid);
    }

}
