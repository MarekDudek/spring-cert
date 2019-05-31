package com.marekdudek.springcert.profiles;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootConfiguration
@Profile("profile-a")
class ConfigA
{
    @Bean
    ComponentA componentA()
    {
        return new ComponentA("straight As");
    }
}
