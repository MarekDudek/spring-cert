package com.marekdudek.springcert.collections;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@SpringBootConfiguration
@ComponentScan
class CollectionInjectionConfig
{
    @Bean
    Set<Integer> setOfIntegers()
    {
        return ImmutableSet.of(1, 2, 3);
    }

    @Bean
    Set<String> setOfStrings()
    {
        return ImmutableSet.of("one", "two", "three");
    }

    @Bean
    List rawListOfIntegers()
    {
        return ImmutableList.of(4, 5, 6);
    }

    @Bean
    List<String> listOfStrings()
    {
        return ImmutableList.of("four", "five", "six");
    }

    @Bean
    Map<Integer, Integer> mapOfIntegerToInteger()
    {
        return ImmutableMap.<Integer, Integer>builder().
                put(7, 7).
                put(8, 8).
                put(9, 9).
                build();
    }

    @Bean
    Map rawMapOfIntegerToInteger()
    {
        return ImmutableMap.<Integer, Integer>builder().
                put(10, 10).
                put(11, 11).
                put(12, 12).
                build();
    }

    @Bean
    Map<Integer, ?> rightHalfRawMapOfIntegerToInteger()
    {
        return ImmutableMap.<Integer, Integer>builder().
                put(13, 13).
                put(14, 14).
                put(15, 15).
                build();
    }

    @Bean
    Map<?, Integer> leftHalfRawMapOfIntegerToInteger()
    {
        return ImmutableMap.<Integer, Integer>builder().
                put(16, 16).
                put(17, 17).
                put(18, 18).
                build();
    }

    @Bean
    Properties properties()
    {
        final Properties props = new Properties();
        props.put("one", "1");
        props.put("two", "2");
        props.put("three", "3");
        return props;
    }

    @Bean
    Long oneLong()
    {
        return 7L;
    }

    @Bean
    Long twoLong()
    {
        return 8L;
    }

    @Bean
    Long threeLong()
    {
        return 9L;
    }

    @Bean
    List<Long> listOfLongs()
    {
        return ImmutableList.of(4L, 5L, 6L);
    }
}
