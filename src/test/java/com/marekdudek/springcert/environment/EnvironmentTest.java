package com.marekdudek.springcert.environment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

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

    @Test
    void default_profiles()
    {
        // when
        final String[] profiles = environment.getDefaultProfiles();
        // then
        assertThat(profiles).containsExactly("default");
    }

    @Test
    void accepts_profiles()
    {
        // when
        final boolean accepts = environment.acceptsProfiles(Profiles.of("!profile-3"));
        // then
        assertThat(accepts).isTrue();
    }

    @Test
    void properties()
    {
        assertThatCode(() ->
                {
                    environment.getRequiredProperty("user.name");
                    environment.getRequiredProperty("os.name");
                    environment.getRequiredProperty("spring.profiles.active");
                }
        ).doesNotThrowAnyException();
    }
}
