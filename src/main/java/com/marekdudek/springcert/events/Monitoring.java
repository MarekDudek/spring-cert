package com.marekdudek.springcert.events;

import org.springframework.context.event.*;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkArgument;
import static com.marekdudek.springcert.events.Monitoring.Status.*;
import static org.apache.commons.lang3.BooleanUtils.isFalse;

@Component
final class Monitoring
{
    enum Status
    {
        Before,
        During,
        After
    }

    Status status = Before;
    boolean running = false;

    @EventListener
    public void refreshed(final ContextRefreshedEvent event)
    {
        checkArgument(status == Before);
        status = During;
    }

    @EventListener
    public void started(final ContextStartedEvent event)
    {
        checkArgument(isFalse(running));
        running = true;
    }

    @EventListener
    public void stopped(final ContextStoppedEvent event)
    {
        checkArgument(running);
        running = false;
    }

    @EventListener
    public void closed(final ContextClosedEvent event)
    {
        checkArgument(status == During);
        status = After;
    }
}
