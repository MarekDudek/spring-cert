package com.marekdudek.springcert.messages.implementations;

import com.marekdudek.springcert.messages.interfaces.MessageSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static com.marekdudek.springcert.messages.MessagesTestConstants.MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;

final class ConstMessageSupplierTest
{
    // System under test
    private MessageSupplier supplier;

    @BeforeEach
    void setUp()
    {
        supplier =
                ConstMessageSupplier.builder().
                        message(MESSAGE).build();
    }

    @RepeatedTest(10)
    void supplier_always_returns_the_same_message()
    {
        // when
        final String message = supplier.message();
        // then
        assertThat(message).isEqualTo(MESSAGE);
    }
}
