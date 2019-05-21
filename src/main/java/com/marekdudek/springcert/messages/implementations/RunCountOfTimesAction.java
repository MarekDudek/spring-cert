package com.marekdudek.springcert.messages.implementations;

import com.marekdudek.springcert.messages.interfaces.MessageAction;
import com.marekdudek.springcert.messages.interfaces.MessageConsumer;
import com.marekdudek.springcert.messages.interfaces.MessageSupplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

import static lombok.AccessLevel.PUBLIC;

@Component
@AllArgsConstructor(onConstructor = @_(@Autowired))
@Builder
@FieldDefaults(level = PUBLIC, makeFinal = true)
public final class RunCountOfTimesAction implements MessageAction
{
    @NonNull
    MessageSupplier supplier;
    @NonNull
    MessageConsumer consumer;
    @NonNull
    int count;

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
