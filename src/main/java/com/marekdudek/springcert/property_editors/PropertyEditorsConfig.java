package com.marekdudek.springcert.property_editors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootConfiguration
@ComponentScan
@PropertySource({"classpath:/blood.properties", "classpath:/complex.properties"})
class PropertyEditorsConfig
{

   /* @Bean
    Blood blood(
            @Value("blood.type") final BloodType type,
            @Value("blood.rh") final RhFactor rh
    )
    {
        return new Blood(type, rh);
    }*/


    @Bean
    ComplexBean complexBean(
            @Value("${complex.class}") final Class clazz
    )
    {
        return new ComplexBean(clazz);
    }
}
