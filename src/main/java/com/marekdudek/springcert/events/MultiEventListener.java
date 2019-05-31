package com.marekdudek.springcert.events;

import org.springframework.context.event.*;
import org.springframework.stereotype.Component;

@Component
final class MultiEventListener
{
    int events = 0;

    @EventListener(
            {
                    ContextRefreshedEvent.class,
                    ContextStartedEvent.class,
                    ContextStoppedEvent.class,
                    ContextClosedEvent.class
            })
    public void applicationEvents(final @SuppressWarnings("unused") ApplicationContextEvent event)
    {
        events++;
    }
}
