package com.training.ee.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.security.Principal;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yusufyazici on 16/02/2018.
 */

@ServerEndpoint("/wspath")
public class ServerSideWebSocket {

    private static Set<Session> allSessions = new HashSet<Session>();


    public static Set<Session> getAllSessions() {
        return allSessions;
    }

    public static void setAllSessions(Set<Session> allSessions) {
        ServerSideWebSocket.allSessions = allSessions;
    }

    public void addToSessions(Session session){
        allSessions.add(session);
    }

    @OnMessage
    public void message(Session session, String message){

        session.getAsyncRemote().sendText(message + "_received");
    }

    @OnError
    public void error(Session session, Throwable exception){


    }

    @OnOpen
    public void open(Session session, EndpointConfig endpointConfig){
        MyThread myThread = new MyThread(session);
        myThread.start();
        Map<String, Object> userProperties = session.getUserProperties();
        System.out.println(userProperties);


        addToSessions(session);

    }

    @OnClose
    public void close(Session session, CloseReason closeReason){

        System.out.println(closeReason);

    }

    public static class MyThread extends Thread{
        private Session mySession;

        private int counter = 0;

        public MyThread(Session session){
            super();
            this.mySession = session;
        }

        @Override
        public void run() {
            while (true){
                try{
                    Thread.sleep(5000L);
                    mySession.getAsyncRemote().sendText("message " + counter++);;
                } catch(Exception e){

                }
            }
        }
    }
}
