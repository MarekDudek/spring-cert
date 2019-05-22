package com.marekdudek.springcert.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

@SpringBootTest
class CollectionInjectionTest
{
    @Autowired
    private Containers bean; // System under test

    @Test
    @DisplayName("Set is properly injected when generics in class and config match")
    void set_injection()
    {
        assertThat(bean.integerSet).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("List is not injected when class has parametrized type and config has raw type")
    void list_injection()
    {
        assertThat(bean.integerList).isEmpty();
    }

    @Test
    @DisplayName("Map is properly injected when generics in class and config match")
    void map_injection()
    {
        assertThat(bean.integerToIntegerMap).containsExactly(entry(7, 7), entry(8, 8), entry(9, 9));
    }

    @Test
    @DisplayName("Map is properly injected despite multiple candidates when name of bean in class and config match")
    @SuppressWarnings("unchecked")
    void raw_map_injection()
    {
        assertThat(bean.rawMapOfIntegerToInteger).containsExactly(entry(10, 10), entry(11, 11), entry(12, 12));
    }

    @Test
    @DisplayName("Properties are properly injected")
    void properties_injection()
    {
        assertThat(bean.properties).containsOnly(entry("one", "1"), entry("two", "2"), entry("three", "3"));
    }
}
