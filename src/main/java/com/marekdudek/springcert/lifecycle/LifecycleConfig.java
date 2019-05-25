package com.marekdudek.springcert.lifecycle;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
class LifecycleConfig
{
    @Bean(initMethod = "start", destroyMethod = "stop")
    Cycling cycling()
    {
        return new Cycling("some string");
    }
}
