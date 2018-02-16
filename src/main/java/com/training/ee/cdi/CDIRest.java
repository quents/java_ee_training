package com.training.ee.cdi;

import com.training.ee.model.Person;
import com.training.ee.websocket.ServerSideWebSocket;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.websocket.Session;
import javax.ws.rs.*;
import java.util.Set;

/**
 * Created by yusufyazici on 14/02/2018.
 */
@Path("/cdi")
public class CDIRest {

    public CDIRest() {
        System.out.println("*********** CDI constructor called");
    }

    @Inject // Spring CDI kullanir, bu yüzden Spring te de Inject kullanilabililir
    //@Named("yusuf1")
    //@MySelAnno
    @Named("impl3")
    private IExecute exec;

    @Inject
    @Named("genderConfigurer")
    private IProcessGender iProcessGender;

    @Inject
    private PersonHolder personHolder;

    @Inject
    private ServerSideWebSocket serverSideWebSocket;

    @PUT
    @Path("/getPerson")
    public String getPerson(Person person){

        personHolder.setPerson(person);
        return "OK";
    }

    @POST
    @Path("/processPerson")
    public String processPerson(){

        return iProcessGender.processGender(personHolder.getPerson());
    }

    @GET
    @Path("/sendToWebSocket")
    public String sendToWebSocket(@QueryParam("name") String name) throws InterruptedException {

        Set<Session> allSessions = serverSideWebSocket.getAllSessions();
        for (Session aSession: allSessions
             ) {
            aSession.getAsyncRemote().sendText(name + "gonderiyorum");
        }

        return name;
    }

    @GET
    public String method1(){
        return exec.execute();
    }
}
