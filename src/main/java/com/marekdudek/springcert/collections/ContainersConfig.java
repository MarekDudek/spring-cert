package com.marekdudek.springcert.collections;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootConfiguration
@ComponentScan
class ContainersConfig
{
    @Bean
    Set<Integer> setOfIntegers()
    {
        return Sets.newHashSet(1, 2, 3);
    }

    @Bean
    Set<String> setOfStrings()
    {
        return Sets.newHashSet("one", "two", "three");
    }

    @Bean
    List rawListOfIntegers()
    {
        return Lists.newArrayList(4, 5, 6);
    }

    @Bean
    List<String> listOfStrings()
    {
        return Lists.newArrayList("four", "five", "six");
    }

    @Bean
    Map<Integer, Integer> mapOfIntegerToInteger()
    {
        final HashMap<Integer, Integer> map = Maps.newHashMap();
        map.put(7, 49);
        map.put(8, 64);
        map.put(9, 81);
        return map;
    }
}
