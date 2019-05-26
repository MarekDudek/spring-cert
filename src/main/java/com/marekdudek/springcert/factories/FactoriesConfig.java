package com.marekdudek.springcert.factories;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.security.NoSuchAlgorithmException;

@SpringBootConfiguration
class FactoriesConfig
{
    @Bean
    MessageDigestFactoryBean md5() throws NoSuchAlgorithmException
    {
        return new MessageDigestFactoryBean("MD5");
    }

    @Bean
    MessageDigestFactoryBean sha() throws NoSuchAlgorithmException
    {
        return new MessageDigestFactoryBean("SHA");
    }
}
