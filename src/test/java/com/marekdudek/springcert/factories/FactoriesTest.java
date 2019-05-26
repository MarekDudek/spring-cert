package com.marekdudek.springcert.factories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.MessageDigest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
final class FactoriesTest
{
    @Autowired
    private MessageDigest md5;

    @Autowired
    private MessageDigest sha;

    @Test
    void md5()
    {
        // when
        final byte[] bytes = md5.digest("secret".getBytes());
        final String string = new HexBinaryAdapter().marshal(bytes);
        // then
        assertThat(string).isEqualTo("5EBE2294ECD0E0F08EAB7690D2A6EE69");
    }

    @Test
    void sha()
    {
        // when
        final byte[] bytes = sha.digest("secret".getBytes());
        final String string = new HexBinaryAdapter().marshal(bytes);
        // then
        assertThat(string).isEqualTo("E5E9FA1BA31ECD1AE84F75CAAA474F3A663F05F4");
    }

    @Autowired
    private Integer integer;

    @Autowired
    private String string;

    @Test
    void factory_of_numbers()
    {
        assertThat(integer).isEqualTo(12345);
    }

    @Test
    void factory_of_strings()
    {
        assertThat(string).isEqualTo("quick brown fox jumps over the lazy dog");
    }
}
