package com.marekdudek.springcert.aspects;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootConfiguration
@EnableAspectJAutoProxy
@ComponentScan
class AspectsConfig
{
}
