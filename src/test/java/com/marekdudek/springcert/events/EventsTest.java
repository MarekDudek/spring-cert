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

import static com.marekdudek.springcert.events.Monitoring.Status.After;
import static com.marekdudek.springcert.events.Monitoring.Status.During;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@SpringBootTest
final class EventsTest
{
    @Autowired
    private ApplicationEventPublisher publisher;

    @MockBean
    private ApplicationListener<SomeEvent> listener;


    @Test
    void test()
    {
        // given
        final SomeEvent event = new SomeEvent(publisher, "some content");
        // when
        publisher.publishEvent(event);
        // then
        verify(listener).onApplicationEvent(event);
    }


    @Test
    @SuppressWarnings("unchecked")
    void context_events()
    {
        // given
        final Consumer<ContextRefreshedEvent> refreshed = mock(Consumer.class);
        final Consumer<ContextStartedEvent> started = mock(Consumer.class);
        final Consumer<ContextStoppedEvent> stopped = mock(Consumer.class);
        final Consumer<ContextClosedEvent> closed = mock(Consumer.class);
        final InOrder inOrder = inOrder(refreshed, started, stopped, closed);
        // given
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EventsConfig.class);
        context.registerBean("refreshed", Consumer.class, () -> refreshed, DontCustomize);
        context.registerBean("started", Consumer.class, () -> started, DontCustomize);
        context.registerBean("stopped", Consumer.class, () -> stopped, DontCustomize);
        context.registerBean("closed", Consumer.class, () -> closed, DontCustomize);
        // when
        context.refresh();
        // then
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
        // then
        inOrder.verifyNoMoreInteractions();
        verifyNoMoreInteractions(refreshed, started, stopped, closed);
    }

    private static final BeanDefinitionCustomizer DontCustomize =
            definition ->
            {
            };

    @Test
    void annotation_based_event_listeners()
    {
        // given
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EventsConfig.class);
        context.register(Monitoring.class);
        // when
        context.refresh();
        final Monitoring monitoring = context.getBean(Monitoring.class);
        context.publishEvent(new SomeEvent(context, "hello, world"));
        // then
        assertThat(monitoring).extracting(m -> m.status).isEqualTo(During);
        assertThat(monitoring).extracting(m -> m.running).isEqualTo(false);
        // when
        context.start();
        // then
        assertThat(monitoring).extracting(m -> m.running).isEqualTo(true);
        // when
        context.stop();
        // then
        assertThat(monitoring).extracting(m -> m.running).isEqualTo(false);
        // when
        context.start();
        // then
        assertThat(monitoring).extracting(m -> m.running).isEqualTo(true);
        // when
        context.stop();
        // then
        assertThat(monitoring).extracting(m -> m.running).isEqualTo(false);
        // when
        context.close();
        // then
        assertThat(monitoring).extracting(m -> m.status).isEqualTo(After);
        assertThat(monitoring.events).isEqualTo(7);
    }
}
