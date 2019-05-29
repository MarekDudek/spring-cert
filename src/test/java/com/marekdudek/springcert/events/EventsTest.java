package com.marekdudek.springcert.events;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinitionCustomizer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

import java.util.function.Consumer;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

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

    private static final BeanDefinitionCustomizer DontCustomize =
            definition ->
            {
            };

    @Test
    void context_events()
    {
        // when
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EventsConfig.class);
        context.registerBean("refreshed", Consumer.class, () -> refreshed, DontCustomize);
        context.registerBean("started", Consumer.class, () -> started, DontCustomize);
        context.registerBean("stopped", Consumer.class, () -> stopped, DontCustomize);
        context.registerBean("closed", Consumer.class, () -> closed, DontCustomize);
        context.refresh();
        // then
        final InOrder inOrder = inOrder(refreshed, started, stopped, closed);
        inOrder.verify(refreshed).accept(argThat(e -> !e.getSource().equals(context)));
        inOrder.verify(refreshed).accept(argThat(e -> e.getSource().equals(context)));
        // when
        context.start();
        // then
        inOrder.verify(started).accept(argThat(e -> e.getSource().equals(context)));
        // when
        context.stop();
        // then
        inOrder.verify(stopped).accept(argThat(e -> e.getSource().equals(context)));
        // when
        context.close();
        // then
        inOrder.verify(closed).accept(argThat(e -> e.getSource().equals(context)));
        inOrder.verifyNoMoreInteractions();
        verifyNoMoreInteractions(refreshed, started, stopped, closed);
    }
}
