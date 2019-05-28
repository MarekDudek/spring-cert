package com.marekdudek.springcert.events;

import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@ToString
final class SomeEvent extends ApplicationEvent
{
    public final String name;

    public SomeEvent(final Object source, final String name)
    {
        super(source);
        this.name = name;
    }
}
