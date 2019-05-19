package com.marekdudek.springcert.messages.implementations;

import com.marekdudek.springcert.messages.interfaces.MessageAction;
import com.marekdudek.springcert.messages.interfaces.MessageConsumer;
import com.marekdudek.springcert.messages.interfaces.MessageSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public final class RunCountOfTimesAction implements MessageAction
{
    private final MessageSupplier supplier;
    private final MessageConsumer consumer;
    private final int count;

    @Autowired
    public RunCountOfTimesAction
            (
                    final MessageSupplier supplier,
                    final MessageConsumer consumer,
                    final int count)
    {
        this.supplier = supplier;
        this.consumer = consumer;
        this.count = count;
    }


    @Override
    public void run()
    {
        IntStream.range(0, count).forEach(i ->
                {
                    final String message = supplier.message();
                    consumer.render(message);
                }
        );
    }
}
