package com.marekdudek.springcert.messages;

import com.marekdudek.springcert.messages.implementations.RunCountOfTimesAction;
import com.marekdudek.springcert.messages.interfaces.MessageAction;
import com.marekdudek.springcert.messages.interfaces.MessageConsumer;
import com.marekdudek.springcert.messages.interfaces.MessageSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
final class MessagesTest
{
    @Mock
    private MessageSupplier supplier;
    @Mock
    private MessageConsumer consumer;

    // System under test
    private MessageAction action;

    @BeforeEach
    void setUp()
    {
        given(supplier.message()).willReturn(MESSAGE);
        action = new RunCountOfTimesAction(supplier, consumer, TIMES);
    }

    private static final String MESSAGE = "message";
    private static final int TIMES = 3;

    @Test
    void test()
    {
        // when
        action.run();
        // then
        verify(supplier, times(TIMES)).message();
        verify(consumer, times(TIMES)).render(MESSAGE);
        verifyNoMoreInteractions(supplier, consumer);
    }

    @Test
    void order_of_execution()
    {
        // when
        action.run();
        // then
        final InOrder order = inOrder(supplier, consumer);
        order.verify(supplier).message();
        order.verify(consumer).render(MESSAGE);
        order.verify(supplier).message();
        order.verify(consumer).render(MESSAGE);
        order.verify(supplier).message();
        order.verify(consumer).render(MESSAGE);
        verifyNoMoreInteractions(supplier, consumer);
    }
}
