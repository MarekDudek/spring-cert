package com.marekdudek.springcert.events;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

import java.util.function.Consumer;

@SpringBootConfiguration
abstract class EventsConfig
{
    @Bean
    ApplicationListener<ContextRefreshedEvent> refreshedListener(final Consumer<ContextRefreshedEvent> refreshedConsumer)
    {
        return refreshedConsumer::accept;
    }

    @Bean
    ApplicationListener<ContextStartedEvent> startedListener(final Consumer<ContextStartedEvent> startedConsumer)
    {
        return startedConsumer::accept;
    }

    @Bean
    ApplicationListener<ContextStoppedEvent> stoppedListener(final Consumer<ContextStoppedEvent> stoppedConsumer)
    {
        return stoppedConsumer::accept;
    }

    @Bean
    ApplicationListener<ContextClosedEvent> closedListener(final Consumer<ContextClosedEvent> closedConsumer)
    {
        return closedConsumer::accept;
    }


    @Lookup
    abstract Consumer<ContextRefreshedEvent> refreshedConsumer();

    @Lookup
    abstract Consumer<ContextStartedEvent> startedConsumer();

    @Lookup
    abstract Consumer<ContextStoppedEvent> stoppedConsumer();

    @Lookup
    abstract Consumer<ContextClosedEvent> closedConsumer();


    @Bean
    static <T> Consumer<T> ignore()
    {
        return ignored ->
        {
        };
    }
}
