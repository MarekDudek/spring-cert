package com.marekdudek.springcert.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ApplicationEventPublisher;
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
    ApplicationListener<ContextRefreshedEvent> refreshedListener(final Consumer<ContextRefreshedEvent> refreshed)
    {
        return refreshed::accept;
    }

    @Bean
    ApplicationListener<ContextStartedEvent> startedListener(final Consumer<ContextStartedEvent> started)
    {
        return started::accept;
    }

    @Bean
    ApplicationListener<ContextStoppedEvent> stoppedListener(final Consumer<ContextStoppedEvent> stopped)
    {
        return stopped::accept;
    }

    @Bean
    ApplicationListener<ContextClosedEvent> closedListener(final Consumer<ContextClosedEvent> closed)
    {
        return closed::accept;
    }


    @Lookup
    abstract Consumer<ContextRefreshedEvent> refreshed();

    @Lookup
    abstract Consumer<ContextStartedEvent> started();

    @Lookup
    abstract Consumer<ContextStoppedEvent> stopped();

    @Lookup
    abstract Consumer<ContextClosedEvent> closed();


    @Bean
    static <T> Consumer<T> ignore()
    {
        return ignored ->
        {
        };
    }





}
