package com.marekdudek.springcert.messages.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;

import static com.marekdudek.springcert.messages.implementations.MessagesTestConstants.MESSAGE;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
final class PrintStreamMessageConsumerTest
{
    // System under test
    private PrintStreamMessageConsumer consumer;

    @Mock
    private PrintStream printStream;

    @BeforeEach
    void setUp()
    {
        consumer =
                PrintStreamMessageConsumer.builder().
                        printStream(printStream).
                        build();
    }

    @Test
    void consumer_prints_line_and_new_line()
    {
        // when
        consumer.render(MESSAGE);
        // then
        verify(printStream).println(MESSAGE);
    }
}
