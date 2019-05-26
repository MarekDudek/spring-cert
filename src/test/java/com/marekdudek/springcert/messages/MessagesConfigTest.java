package com.marekdudek.springcert.messages;

import com.marekdudek.springcert.messages.implementations.ConstMessageSupplier;
import com.marekdudek.springcert.messages.implementations.PrintStreamMessageConsumer;
import com.marekdudek.springcert.messages.implementations.RunCountOfTimesAction;
import com.marekdudek.springcert.messages.interfaces.MessageAction;
import com.marekdudek.springcert.messages.interfaces.MessageConsumer;
import com.marekdudek.springcert.messages.interfaces.MessageSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.assertj.AssertableApplicationContext;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

import static com.marekdudek.springcert.messages.MessagesTestConstants.MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@SpringBootTest
final class MessagesConfigTest
{
    @Autowired
    private MessageAction action; // System under test

    @MockBean
    private MessageSupplier supplier;
    @MockBean
    private MessageConsumer consumer;

    @Autowired
    private ConfigurableApplicationContext ctx;

    private AssertableApplicationContext context;

    @PostConstruct
    void init()
    {
        context = AssertableApplicationContext.get(() -> ctx);
    }

    @BeforeEach
    void setUp()
    {
        given(supplier.message()).willReturn(MESSAGE);
        doNothing().when(consumer).render(MESSAGE);
    }

    @Test
    void action_runs_properly()
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

    @Test
    void types()
    {
        // action
        assertThat(action).isExactlyInstanceOf(RunCountOfTimesAction.class);
        assertThat(context).getBean(MessageAction.class).isExactlyInstanceOf(RunCountOfTimesAction.class);
        // supplier
        assertThat(supplier).isNotExactlyInstanceOf(ConstMessageSupplier.class);
        assertThat(context).getBean(MessageSupplier.class).isNotExactlyInstanceOf(ConstMessageSupplier.class);
        assertThat(context).hasSingleBean(MessageSupplier.class);
        assertThat(context).getBeans(MessageSupplier.class).containsOnlyKeys("constMessageSupplier");
        // consumer
        assertThat(consumer).isNotExactlyInstanceOf(PrintStreamMessageConsumer.class);
        assertThat(context).getBean(MessageConsumer.class).isNotExactlyInstanceOf(PrintStreamMessageConsumer.class);
        assertThat(context).hasSingleBean(MessageConsumer.class);
        assertThat(context).getBeans(MessageConsumer.class).containsOnlyKeys("printStreamMessageConsumer");
    }
}
