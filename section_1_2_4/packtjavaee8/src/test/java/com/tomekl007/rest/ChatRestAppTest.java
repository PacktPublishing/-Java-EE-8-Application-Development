package com.tomekl007.rest;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.test.TestPortProvider;
import org.junit.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class ChatRestAppTest {

    private static UndertowJaxrsServer server;

    @BeforeClass
    public static void init() throws Exception
    {
        server = new UndertowJaxrsServer().start();
    }

    @AfterClass
    public static void stop() throws Exception
    {
        server.stop();
    }

    @Ignore
    @Test
    public void testApplicationPath() throws Exception
    {
        server.deploy(ChatRestApp.class);
        Client client = ClientBuilder.newClient();
        String val = client.target(TestPortProvider.generateURL("/api/chat/ping"))
                .request().get(String.class);
        Assert.assertEquals("Service online", val);
        client.close();
    }

}