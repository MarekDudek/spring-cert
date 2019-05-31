package com.marekdudek.springcert.events;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
final class RichListener
{
    int events = 0;

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
}
