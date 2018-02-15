package com.training.ee.ejb;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.container.AsyncResponse;

import com.training.ee.model.Person;

import java.util.List;
import java.util.concurrent.Future;

/**
 * Session Bean implementation class PersonDAO
 */
@Stateless
@LocalBean
public class PersonDAO {

    @PersistenceContext(unitName = "TTJavaEE")
    private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public PersonDAO() {
        // TODO Auto-generated constructor stub
    }
    
    public int getId() {
        return 0;
    }
    
    public void save(Person person) {
        entityManager.persist(person);
    }

    public List<Person> getPersonByName(String name){
        TypedQuery<Person> createQuery = entityManager.createNamedQuery("select_by_name", Person.class);
        createQuery.setParameter("isim", name);
        return createQuery.getResultList();
    }

    public List<Person> getPersonByNameNative(){
        Query query = entityManager.createNamedQuery("select_by_name_native", Person.class);
        entityManager.setProperty("isim", "yusuf");
        return query.getResultList();
    }

    @Asynchronous
    public Future<Person> findPerson(long personId){
        return new AsyncResult<Person>(entityManager.find(Person.class, personId));
    }


    public String findPersonGender(long personId){
        return entityManager.find(Person.class, personId).getCinsiyet();
    }
}
