package com.tomekl007.rest;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class ChatRestApp extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(ChatController.class);
        return classes;
    }

    public static void main(String[] args) {
        UndertowJaxrsServer server = new UndertowJaxrsServer().start();
        server.deploy(ChatRestApp.class);
    }
    //curl http://localhost:8081/api/chat/ping
    /*
   curl -X --header "Content-Type: application/json" \
    --request POST \
    http://localhost:8081/api/chat/1/hello
     */
    /*
        curl -X --header "Content-Type: application/json" \
    --request GET \
    http://localhost:8081/api/chat/1
     */
}