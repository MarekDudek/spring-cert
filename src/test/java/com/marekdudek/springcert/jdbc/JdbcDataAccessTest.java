package com.marekdudek.springcert.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
final class JdbcDataAccessTest
{
    @Autowired
    private JdbcTemplate jdbc;

    @Test
    void connection_to_database_works()
    {
        // when
        final Integer result = jdbc.queryForObject("SELECT 2 + 2", Integer.class);
        // then
        assertThat(result).isEqualTo(4);
    }
}
