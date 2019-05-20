package com.marekdudek.springcert.spel;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @_(@Autowired))
public final class Target
{
    @Value("#{source.name}")
    public final String name;

    @Value("#{source.number}")
    public final int number;
}
