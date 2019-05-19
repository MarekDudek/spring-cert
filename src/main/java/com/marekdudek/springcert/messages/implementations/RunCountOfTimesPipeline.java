package com.marekdudek.springcert.messages.implementations;

import com.marekdudek.springcert.messages.interfaces.MessageConsumer;
import com.marekdudek.springcert.messages.interfaces.MessagePipeline;
import com.marekdudek.springcert.messages.interfaces.MessageSupplier;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.stream.IntStream;

@Builder
@AllArgsConstructor
public final class RunCountOfTimesPipeline implements MessagePipeline
{
    public final int count;

    @Override
    public void run(final MessageSupplier supplier, final MessageConsumer consumer)
    {
        IntStream.range(0, count).forEach(i ->
        {
            final String message = supplier.message();
            consumer.render(message);
        });
    }
}
