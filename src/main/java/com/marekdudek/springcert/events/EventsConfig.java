package com.marekdudek.springcert.events;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.function.Consumer;

@SpringBootConfiguration
@ComponentScan
class EventsConfig
{
    @Bean
    Consumer<SomeEvent> ignore()
    {
        return ignored ->
        {
        };
    }
}
