package com.marekdudek.springcert.spel;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @_(@Autowired))
@Data
@PropertySource("classpath:/source.properties")
public final class Source
{
    @Value("${source.name}")
    private final String name;

    @Value("${source.number}")
    private final int number;
}
