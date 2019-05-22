package com.marekdudek.springcert.collections;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import static lombok.AccessLevel.PUBLIC;

@Component
@AllArgsConstructor
@FieldDefaults(level = PUBLIC, makeFinal = true)
class Containers
{
    Set<Integer> integerSet;

    List<Integer> integerList;

    Map<Integer, Integer> integerToIntegerMap;

    Map rawMapOfIntegerToInteger;

    Properties properties;

    List<Long> longList;
}
