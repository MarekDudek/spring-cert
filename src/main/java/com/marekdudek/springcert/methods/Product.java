package com.marekdudek.springcert.methods;

import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PACKAGE;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(value = SCOPE_PROTOTYPE)
@FieldDefaults(level = PACKAGE, makeFinal = true)
class Product
{
    private static int COUNT = 0;

    int number = ++COUNT;
}
