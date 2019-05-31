package com.marekdudek.springcert.profiles;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootConfiguration
@Profile("profile-b")
class ConfigB
{
    @Bean
    ComponentB componentB()
    {
        return new ComponentB("B-class");
    }
}
