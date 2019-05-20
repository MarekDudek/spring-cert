package com.marekdudek.springcert.spel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
final class SpelTest
{
    @Autowired
    private Source source;
    @Autowired
    private Target target;

    @Test
    void source()
    {
        assertThat(source.name).isEqualTo("Out of the blue");
        assertThat(source.number).isEqualTo(42);
    }

    @Test
    void target()
    {
        assertThat(target.name).isEqualTo("Out of the blue");
        assertThat(target.number).isEqualTo(42);
    }
}
