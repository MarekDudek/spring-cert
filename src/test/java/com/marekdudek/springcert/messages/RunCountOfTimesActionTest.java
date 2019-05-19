package com.marekdudek.springcert.messages;

import com.marekdudek.springcert.messages.implementations.RunCountOfTimesAction;
import com.marekdudek.springcert.messages.interfaces.MessageConsumer;
import com.marekdudek.springcert.messages.interfaces.MessageSupplier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest
final class RunCountOfTimesActionTest
{
    @MockBean
    private MessageSupplier supplier;
    @MockBean
    private MessageConsumer consumer;

    @Autowired
    private RunCountOfTimesAction runCountOfTimesAction;

    @Test
    void test()
    {
        // given
        when(supplier.message()).thenReturn("msg");
        // when
        runCountOfTimesAction.run();
        // then
        verify(supplier, times(3)).message();
        verify(consumer, times(3)).render("msg");
        verifyNoMoreInteractions(supplier, consumer);
    }
}
