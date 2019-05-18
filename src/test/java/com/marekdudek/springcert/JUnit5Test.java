package com.marekdudek.springcert;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

final class JUnit5Test
{
    @Test
    void test()
    {
        assertThat(2 + 2).isEqualTo(4);
        assertThat("Hello," + " World!").hasSize(13);
    }
}
