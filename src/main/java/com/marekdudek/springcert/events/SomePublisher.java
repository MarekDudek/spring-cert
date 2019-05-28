package com.marekdudek.springcert.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
final class SomePublisher implements ApplicationEventPublisherAware
{
    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(final ApplicationEventPublisher publisher)
    {
        this.publisher = publisher;
    }

    void publish(final String name)
    {
        publisher.publishEvent(new SomeEvent(this, name));
    }
}
