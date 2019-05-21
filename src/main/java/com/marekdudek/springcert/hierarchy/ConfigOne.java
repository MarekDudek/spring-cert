package com.marekdudek.springcert.hierarchy;

import org.springframework.context.annotation.Bean;

class ConfigOne
{
    @Bean
    String one()
    {
        return "alpha";
    }

    @Bean
    String two()
    {
        return "beta";
    }
}
