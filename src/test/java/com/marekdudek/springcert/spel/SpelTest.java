package com.marekdudek.springcert.spel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
final class SpelTest
{
    @Autowired
    private Target target; // System under test


    @Autowired
    private Source source;

    @Test
    void test()
    {
        assertThat(target.name).isEqualTo(source.name.toUpperCase());
        assertThat(target.number).isEqualTo(2 * source.number + 1);
        assertThat(target.string).isEqualTo("Hello, World!");
    }
}
