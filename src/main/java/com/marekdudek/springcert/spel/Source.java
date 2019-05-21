package com.marekdudek.springcert.spel;

import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PUBLIC;

@Component
@PropertySource("classpath:/source.properties")
@FieldDefaults(level = PUBLIC)
public final class Source
{
    @Value("${source.name}")
    String name;

    @Value("${source.number}")
    int number;
}
