package com.marekdudek.springcert.events;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.support.GenericApplicationContext;

import java.util.function.Consumer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
final class EventsTest
{
    @Autowired
    private ApplicationEventPublisher publisher;

    @MockBean
    private ApplicationListener<SomeEvent> listener;

    @MockBean
    private Consumer<ContextRefreshedEvent> refreshed;
    @MockBean
    private Consumer<ContextStartedEvent> started;
    @MockBean
    private Consumer<ContextStoppedEvent> stopped;
    @MockBean
    private Consumer<ContextClosedEvent> closed;

    @Test
    void test()
    {
        // given
        final SomeEvent event = new SomeEvent(publisher);
        // when
        publisher.publishEvent(event);
        // then
        verify(listener).onApplicationEvent(event);
    }

    @Test
    void context_events()
    {
        // when
        final GenericApplicationContext context = new AnnotationConfigApplicationContext(EventsConfig.class);
        // then
        // verify(refreshed).accept(any(ContextRefreshedEvent.class));
        // when
        context.start();
        // then
        // verify(started).accept(any(ContextStartedEvent.class));
        // when
        context.stop();
        // then
        // verify(stopped).accept(any(ContextStoppedEvent.class));
        // verify(closed).accept(any(ContextClosedEvent.class));
    }
}
