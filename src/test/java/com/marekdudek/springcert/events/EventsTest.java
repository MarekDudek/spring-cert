package com.marekdudek.springcert.events;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;

import java.util.function.Consumer;

import static org.mockito.Mockito.verify;

@SpringBootTest
final class EventsTest
{
    @Autowired
    private ApplicationEventPublisher publisher;

    @MockBean
    private Consumer<SomeEvent> consumer;

    @Test
    void test()
    {
        // given
        final SomeEvent event = new SomeEvent(publisher);
        // when
        publisher.publishEvent(event);
        // then
        verify(consumer).accept(event);
    }
}
