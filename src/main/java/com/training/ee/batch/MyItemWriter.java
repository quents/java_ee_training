package com.training.ee.batch;

import javax.annotation.Resource;
import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;

/**
 * Created by yusufyazici on 16/02/2018.
 */
@Named("myWriter")
public class MyItemWriter extends AbstractItemWriter {

    @PersistenceContext(unitName = "TTJavaEE")
    private EntityManager em;

    @Resource
    private UserTransaction ut;

    @Override
    public void writeItems(List<Object> items) throws Exception {


            for (Object object: items) {
                Employee employee = (Employee) object;
                em.persist(employee);
            }
    }
}
