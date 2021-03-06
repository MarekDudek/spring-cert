package com.marekdudek.springcert.methods;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
final class MethodInjectionTest
{
    @Autowired
    private Utilizer utilizer; // System under test


    @RepeatedTest(10)
    void lookup_method_injection(final RepetitionInfo info)
    {
        // when
        final Product product = utilizer.supplier();
        // then
        assertThat(product.number).isEqualTo(info.getCurrentRepetition());
        assertThat(utilizer.number).isEqualTo(1);
        // types
        assertThat(product).isExactlyInstanceOf(Product.class);
    }

    @Test
    void types()
    {
        // then
        assertThat(utilizer).isNotExactlyInstanceOf(Utilizer.class);
    }
}
