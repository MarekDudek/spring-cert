package com.marekdudek.springcert.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public final class Target
{
    @Value("#{source.name.toUpperCase()}")
    public String name;

    @Value("#{2 * source.number + 1}")
    public int number;

    @Value("#{'Hello'.concat(', World!')}")
    public String string;
}
