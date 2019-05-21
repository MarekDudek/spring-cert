package com.marekdudek.springcert.spel;

import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PUBLIC;

@Component
@FieldDefaults(level = PUBLIC)
public final class Target
{
    @Value("#{source.name.toUpperCase()}")
    String name;

    @Value("#{2 * source.number + 1}")
    int number;

    @Value("#{'Hello'.concat(', World!')}")
    String string;
}
