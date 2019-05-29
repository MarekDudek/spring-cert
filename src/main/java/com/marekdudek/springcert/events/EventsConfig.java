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

    @Bean
    Consumer<ContextRefreshedEvent> refreshedConsumer()
    {
        return ignore();
    }

    @Bean
    Consumer<ContextStartedEvent> startedConsumer()
    {
        return ignore();
    }

    @Bean
    Consumer<ContextStoppedEvent> stoppedConsumer()
    {
        return ignore();
    }

    @Bean
    Consumer<ContextClosedEvent> closedConsumer()
    {
        return ignore();
    }
}
