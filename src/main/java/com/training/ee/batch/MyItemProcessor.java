package com.training.ee.batch;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

/**
 * Created by yusufyazici on 16/02/2018.
 */
@Named("myprocessor")
public class MyItemProcessor implements ItemProcessor {

    @Override
    public Object processItem(Object item) throws Exception {
        String str = (String) item;
        String [] split = str.split(",");
        Employee employee = new Employee();
        employee.setName(split[0]);
        employee.setAge(Integer.parseInt(split[1]));
        return  employee;
    }
}
