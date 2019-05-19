package com.marekdudek.springcert.messages;

import com.marekdudek.springcert.messages.implementations.DefaultAction;
import com.marekdudek.springcert.messages.interfaces.MessageConsumer;
import com.marekdudek.springcert.messages.interfaces.MessageSupplier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest
final class DefaultActionTest
{
    @MockBean
    private MessageSupplier supplier;
    @MockBean
    private MessageConsumer consumer;


    @Autowired
    private DefaultAction action;

    @Test
    void test()
    {
        // given
        when(supplier.message()).thenReturn("msg");
        // when
        action.run();
        // then
        verify(supplier, times(3)).message();
        verify(consumer, times(3)).render("msg");
    }
}
