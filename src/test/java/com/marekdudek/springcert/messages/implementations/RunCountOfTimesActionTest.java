package com.marekdudek.springcert.messages.implementations;

import com.marekdudek.springcert.messages.interfaces.MessageAction;
import com.marekdudek.springcert.messages.interfaces.MessageConsumer;
import com.marekdudek.springcert.messages.interfaces.MessageSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.marekdudek.springcert.messages.MessagesTestConstants.MESSAGE;
import static com.marekdudek.springcert.messages.MessagesTestConstants.THREE;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
final class RunCountOfTimesActionTest
{
    // System under test
    private MessageAction action;

    @Mock
    private MessageSupplier supplier;
    @Mock
    private MessageConsumer consumer;

    @BeforeEach
    void setUp()
    {
        action =
                RunCountOfTimesAction.builder().
                        supplier(supplier).
                        consumer(consumer).
                        count(THREE).
                        build();
        given(supplier.message()).willReturn(MESSAGE);
    }

    @Test
    void action_runs_specified_number_of_times()
    {
        // when
        action.run();
        // then
        verify(supplier, times(THREE)).message();
        verify(consumer, times(THREE)).render(MESSAGE);
        verifyNoMoreInteractions(supplier, consumer);
    }

    @Test
    void action_runs_specified_number_of_times_in_prescribed_order()
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
