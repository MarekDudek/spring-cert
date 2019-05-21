package com.marekdudek.springcert.spel;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @_(@Autowired))
public final class Target
{
    @Value("#{source.name.toUpperCase()}")
    public final String name;

    @Value("#{2 * source.number + 1}")
    public final int number;

    @Value("#{'Hello'.concat(', World!')}")
    public final String string;
}
