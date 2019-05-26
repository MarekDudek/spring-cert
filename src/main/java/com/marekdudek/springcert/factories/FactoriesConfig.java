package com.marekdudek.springcert.factories;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.security.NoSuchAlgorithmException;

@SpringBootConfiguration
class FactoriesConfig
{
    @Bean
    MessageDigestFactory md5() throws NoSuchAlgorithmException
    {
        return new MessageDigestFactory("MD5");
    }

    @Bean
    MessageDigestFactory sha() throws NoSuchAlgorithmException
    {
        return new MessageDigestFactory("SHA");
    }

    @Bean
    PolymorphicFactory integer()
    {
        return new PolymorphicFactory(12345);
    }

    @Bean
    PolymorphicFactory string()
    {
        return new PolymorphicFactory("quick brown fox jumps over the lazy dog");
    }

    @Bean
    String name() {
        return "some name";
    }
}
