package com.marekdudek.springcert.messages;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import java.io.PrintStream;

@SpringBootConfiguration
@ComponentScan
@PropertySource("classpath:/messages.properties")
class MessagesConfig
{

    @Value("${messages.message}")
    private String message;

    @Value("${messages.count}")
    private int count;

    @Bean
    String message()
    {
        return message;
    }

    @Bean
    PrintStream printStream()
    {
        return System.out;
    }

    @Bean
    Integer count()
    {
        return count;
    }
}
