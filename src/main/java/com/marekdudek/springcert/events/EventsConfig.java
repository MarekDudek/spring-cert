package com.marekdudek.springcert.events;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

import java.util.function.Consumer;

import static java.lang.System.out;

@SpringBootConfiguration
class EventsConfig
{
    private static <T> Consumer<T> ignore()
    {
        return ignored ->
        {
            out.println("ignoring " + ignored);
        };
    }


    @Bean
    Consumer<ContextRefreshedEvent> refreshedConsumer()
    {
        return ignore();
    }

    @Bean
    ApplicationListener<ContextRefreshedEvent> refreshedListener(final Consumer<ContextRefreshedEvent> consumer)
    {
        return consumer::accept;
    }


    @Bean
    Consumer<ContextStartedEvent> startedConsumer()
    {
        return ignore();
    }

    @Bean
    ApplicationListener<ContextStartedEvent> startedListener(final Consumer<ContextStartedEvent> consumer)
    {
        return consumer::accept;
    }


    @Bean
    Consumer<ContextStoppedEvent> stoppedConsumer()
    {
        return ignore();
    }

    @Bean
    ApplicationListener<ContextStoppedEvent> stoppedListener(final Consumer<ContextStoppedEvent> consumer)
    {
        return consumer::accept;
    }


    @Bean
    Consumer<ContextClosedEvent> closedConsumer()
    {
        return ignore();
    }

    @Bean
    ApplicationListener<ContextClosedEvent> closedListener(final Consumer<ContextClosedEvent> consumer)
    {
        return consumer::accept;
    }
}
