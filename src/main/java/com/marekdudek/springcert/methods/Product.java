package com.marekdudek.springcert.methods;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(value = SCOPE_PROTOTYPE)
class Product
{
    private static int COUNT = 0;

    final int number = ++COUNT;
}
