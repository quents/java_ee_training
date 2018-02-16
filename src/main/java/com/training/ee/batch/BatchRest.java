package com.training.ee.batch;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Properties;

/**
 * Created by yusufyazici on 16/02/2018.
 */
@Path("/batch")
public class BatchRest {

    @GET
    public String start(){
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        Properties properties = new Properties();

        long start = jobOperator.start("myjob", properties);
        return "" + start;
    }
}
