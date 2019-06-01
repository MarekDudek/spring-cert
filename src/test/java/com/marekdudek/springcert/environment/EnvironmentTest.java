package com.marekdudek.springcert.environment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles({"profile-1", "profile-2"})
final class EnvironmentTest
{
    @Autowired
    private Environment environment;

    @Test
    void active_profiles()
    {
        // when
        final String[] profiles = environment.getActiveProfiles();
        // then
        assertThat(profiles).containsExactly("profile-1", "profile-2");
    }
}
