package com.tomekl007;

import com.tomekl007.di.interceptor.AuditedInterceptor;
import com.tomekl007.di.service.ChatService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class InterceptorIntegrationTest {
    Weld weld;
    WeldContainer container;

    @Before
    public void init() {
        weld = new Weld();
        container = weld.initialize();
    }

    @After
    public void shutdown() {
        weld.shutdown();
    }

    @Test
    public void givenTheService_whenMethodAndInterceptorExecuted_thenOK() {
        ChatService chatService = container.select(ChatService.class).get();
        String code = "123456";
        chatService.deliverMessage(code);

        Assert.assertTrue(AuditedInterceptor.calledBefore);
        Assert.assertTrue(AuditedInterceptor.calledAfter);
    }

}
