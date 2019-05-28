package com.marekdudek.springcert.events;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.function.Consumer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
final class EventsTest
{
    @Autowired
    private SomePublisher publisher; // system under test


    @MockBean
    private Consumer<SomeEvent> consumer;

    @Test
    void test()
    {
        // when
        publisher.publish("some name");
        // then
        verify(consumer).accept(any(SomeEvent.class));
    }
}
