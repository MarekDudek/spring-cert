package com.marekdudek.springcert.events;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
final class SomeNotifier implements ApplicationListener<SomeEvent>
{
    private final Consumer<SomeEvent> consumer;

    @Override
    public void onApplicationEvent(final SomeEvent event)
    {
        consumer.accept(event);
    }
}
