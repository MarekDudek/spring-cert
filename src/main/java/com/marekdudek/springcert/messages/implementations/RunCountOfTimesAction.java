package com.marekdudek.springcert.messages.implementations;

import com.marekdudek.springcert.messages.interfaces.MessageAction;
import com.marekdudek.springcert.messages.interfaces.MessageConsumer;
import com.marekdudek.springcert.messages.interfaces.MessageSupplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@AllArgsConstructor(onConstructor = @_(@Autowired))
@Builder
public final class RunCountOfTimesAction implements MessageAction
{
    @NonNull
    private final MessageSupplier supplier;
    @NonNull
    private final MessageConsumer consumer;
    @NonNull
    private final int count;

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
