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
    void test()
    {
        // when
        component.method1();
        // then
        assertThat(outStream.toString()).isEqualTo("before\nmethod 1\nafter\n");
    }
}
