package com.marekdudek.springcert.messages;

import com.marekdudek.springcert.messages.implementations.RunCountOfTimesAction;
import com.marekdudek.springcert.messages.interfaces.MessageAction;
import com.marekdudek.springcert.messages.interfaces.MessageConsumer;
import com.marekdudek.springcert.messages.interfaces.MessageSupplier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
final class MessagesTest
{
    @Mock
    private MessageSupplier supplier;
    @Mock
    private MessageConsumer consumer;

    private static final String MESSAGE = "message";
    private static final int TIMES = 3;

    @Test
    void test()
    {
        given(supplier.message()).willReturn(MESSAGE);
        // when
        final MessageAction action = new RunCountOfTimesAction(supplier, consumer, TIMES);
        action.run();
        // then
        verify(supplier, times(TIMES)).message();
        verify(consumer, times(TIMES)).render(MESSAGE);
    }
}
