package com.marekdudek.springcert.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

@SpringBootTest
class ContainersTest
{
    @Autowired
    private Containers bean;

    @Test
    @DisplayName("Set is properly injected when generics in bean and config match")
    void set_injection()
    {
        assertThat(bean.integerSet).contains(1, 2, 3);
    }

    @Test
    @DisplayName("List is not injected when bean has parametrized type and config has raw type")
    void list_injection()
    {
        assertThat(bean.integerList).isEmpty();
    }

    @Test
    @DisplayName("Map is properly injected when generics in bean and config match")
    void map_injection()
    {
        assertThat(bean.integerToIntegerMap).containsExactly(entry(7, 49), entry(8, 64), entry(9, 81));
    }
}
