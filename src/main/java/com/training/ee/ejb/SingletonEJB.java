package com.training.ee.ejb;


import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Created by yusufyazici on 14/02/2018.
 */

//Normal singleton yaparsak eager olma riski var, SingletonExample.class Java core da singleton yapabiliyoruz

@Singleton
@Startup //eager yapar
@DependsOn({}) //depend olabilecek ejb leri verebiliriz
@LocalBean
@ConcurrencyManagement(ConcurrencyManagementType.BEAN) //bunu yaptigimiz zaman concurrency yi kendimiz yonetecegiz asagidaki @Lock ile
//bunları yapmazsak üzerine yazma olabilir
public class SingletonEJB {

    private int index = 0;

    public static final Logger logger = Logger.getLogger(SingletonEJB.class);

    @Resource
    private SessionContext sessionContext;

    @Resource(lookup = "java:jboss/datasources/mysqlDS")
    private DataSource dataSource;


    @PostConstruct
    public void postConstruct(){
        sessionContext.getTimerService().createSingleActionTimer(10000L, new TimerConfig());
    }

    @Timeout
    public void timeout(){
        System.out.println("timeout is here");
        try{
            Connection connection = dataSource.getConnection();
            Statement createStatement = connection.createStatement();
            ResultSet executeQuery = createStatement.executeQuery("SELECT * FROM SPOUSE");
            while(executeQuery.next()){
                String name = executeQuery.getString(2);
                String surname = executeQuery.getString(3);
                logger.info("Name : " + name + " Surname : " + surname);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Lock(LockType.READ) //aynı anda n tane gelebilir
    public int getIndex(){
        return index;
    }

    @Lock(LockType.WRITE) // diger butun her seyi locklar
    public int increaseIndex(){
        return index++;
    }

    @Schedule(hour = "*", minute = "*", second = "10", persistent = false)
    public void execute(){
        System.out.println("execution called");
    }


}
