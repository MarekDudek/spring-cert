package com.marekdudek.springcert.hierarchy;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
class ConfigOne
{
    @Bean
    String stringOne()
    {
        return "one";
    }

    @Bean
    String stringTwo()
    {
        return "two";
    }

    @Bean
    String stringThree()
    {
        return "three";
    }
}
