package com.marekdudek.springcert.events;

import org.springframework.context.ApplicationEvent;


final class SomeEvent extends ApplicationEvent
{
    public final String content;

    SomeEvent(final Object source, String content)
    {
        super(source);
        this.content = content;
    }
}
