package com.tomekl007.dependencyinjection;


import static org.assertj.core.api.Assertions.assertThat;

import com.tomekl007.di.factories.TimeLoggerFactory;
import com.tomekl007.di.loggers.TimeLogger;
import org.junit.Test;

public class TimeLoggerFactoryUnitTest {
    
    @Test
    public void givenTimeLoggerFactory_whenCalledgetTimeLogger_thenOneAssertion() {
        TimeLoggerFactory timeLoggerFactory = new TimeLoggerFactory();
        assertThat(timeLoggerFactory.getTimeLogger()).isInstanceOf(TimeLogger.class);
    }
}
