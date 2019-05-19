package com.marekdudek.springcert.messages;

import com.marekdudek.springcert.messages.interfaces.MessageAction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
final class MessagesSpringBootTest
{
    @Test
    void action_one_test(@Autowired final MessageAction actionOne)
    {
        actionOne.run();
    }

    @Test
    void action_two_test(@Autowired final MessageAction actionTwo)
    {
        actionTwo.run();
    }


    @Autowired
    private MessageAction runCountOfTimesAction;

    @Test
    void component()
    {
        runCountOfTimesAction.run();
    }
}
