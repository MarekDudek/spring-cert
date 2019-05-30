package com.marekdudek.springcert.events;

import org.springframework.context.event.*;
import org.springframework.stereotype.Component;

@Component
final class Monitoring
{
    boolean ready;
    boolean running;

    @EventListener
    public void refreshed(final ContextRefreshedEvent event)
    {
        ready = true;
    }

    @EventListener
    public void started(final ContextStartedEvent event)
    {
        running = true;
    }

    @EventListener
    public void stopped(final ContextStoppedEvent event)
    {
        running = false;
    }

    @EventListener
    public void closed(final ContextClosedEvent event)
    {
        ready = false;
    }
}
