package com.marekdudek.springcert.aspects;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.lang.System.setErr;
import static java.lang.System.setOut;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
final class AspectsTest
{
    @Autowired
    private SomeComponent component;
    @Autowired
    private OtherComponent other;

    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errStream = new ByteArrayOutputStream();

    private final PrintStream out = System.out;
    private final PrintStream err = System.err;

    @BeforeEach
    void setUp()
    {
        setOut(new PrintStream(outStream));
        setErr(new PrintStream(errStream));
    }

    @AfterEach
    void tearDown()
    {
        setOut(out);
        setErr(err);
    }

    @Test
    void some_component()
    {
        // when
        component.method1();
        // then
        assertThat(outStream.toString()).isEqualTo("before\nmethod 1\nafter\n");
    }

    @Test
    void other_component()
    {
        // when
        other.method();
        // then
        assertThat(outStream.toString()).isEqualTo(" start \nother-component.method\n finish \n");
    }

    @Test
    void around_advice()
    {
        // when
        final int value = other.printAndGetLength("some param");
        // then
        assertThat(value).isEqualTo(20);
        assertThat(outStream.toString()).isEqualTo(" pre \nSOME PARAM\n post \n");
    }
}
