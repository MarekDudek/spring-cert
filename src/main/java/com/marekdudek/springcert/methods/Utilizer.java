package com.marekdudek.springcert.methods;

import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PACKAGE;

@Component
@FieldDefaults(level = PACKAGE, makeFinal = true)
abstract class Utilizer
{
    private static int COUNT = 0;

    int number = ++COUNT;

    @Lookup
    abstract Product supplier();
}
