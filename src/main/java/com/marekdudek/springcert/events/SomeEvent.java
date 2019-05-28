package com.marekdudek.springcert.events;

import org.springframework.context.ApplicationEvent;

final class SomeEvent extends ApplicationEvent
{
    SomeEvent(final Object source)
    {
        super(source);
    }
}
