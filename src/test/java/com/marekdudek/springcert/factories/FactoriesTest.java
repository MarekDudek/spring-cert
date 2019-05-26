package com.marekdudek.springcert.factories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.MessageDigest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FactoriesTest
{
    @Autowired
    private MessageDigest digest;

    @Test
    void test()
    {
        // when
        final byte[] bytes = digest.digest("secret".getBytes());
        final String string = new HexBinaryAdapter().marshal(bytes);
        // then
        assertThat(string).isEqualTo("5EBE2294ECD0E0F08EAB7690D2A6EE69");
    }
}
