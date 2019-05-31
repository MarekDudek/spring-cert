package com.marekdudek.springcert.events;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
class RichListener
{
    int events = 0;
    int asynchronous = 0;

    @EventListener(condition = "#event.content.startsWith('hello')")
    public void someEvent(final SomeEvent event)
    {
        events++;
    }

    @EventListener
    public SomeEvent republisher(final ContextStartedEvent started)
    {
        return new SomeEvent(started.getSource(), "hello, context");
    }

    @EventListener(condition = "#event.content.contains('error')")
    public void errorous(final SomeEvent event)
    {
        throw new RuntimeException("this was a mistake");
    }

    @EventListener(condition = "#event.content.contains('asynch')")
    @Async
    public void asynchronous(final SomeEvent event)
    {
        asynchronous++;
    }

    @EventListener(condition = "#event.content.contains('oopsie')")
    @Async
    public void errorousAsynchronous(final SomeEvent event)
    {
        throw new RuntimeException("this was asynchronous mistake");
    }
}
