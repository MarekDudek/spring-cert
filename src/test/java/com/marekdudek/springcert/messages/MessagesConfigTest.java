package com.marekdudek.springcert.messages;

import com.marekdudek.springcert.messages.implementations.RunCountOfTimesAction;
import com.marekdudek.springcert.messages.interfaces.MessageConsumer;
import com.marekdudek.springcert.messages.interfaces.MessageSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.marekdudek.springcert.messages.MessagesTestConstants.MESSAGE;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@SpringBootTest
final class MessagesConfigTest
{
    // System under test
    @Autowired
    private RunCountOfTimesAction action;

    @MockBean
    private MessageSupplier supplier;
    @MockBean
    private MessageConsumer consumer;

    @BeforeEach
    void setUp()
    {
        given(supplier.message()).willReturn(MESSAGE);
        doNothing().when(consumer).render(MESSAGE);
    }

    @Test
    void test()
    {
        // when
        action.run();
        // then
        final InOrder order = Mockito.inOrder(supplier, consumer);
        order.verify(supplier).message();
        order.verify(consumer).render(MESSAGE);
        order.verify(supplier).message();
        order.verify(consumer).render(MESSAGE);
        order.verify(supplier).message();
        order.verify(consumer).render(MESSAGE);
        verifyNoMoreInteractions(supplier, consumer);
    }
}
