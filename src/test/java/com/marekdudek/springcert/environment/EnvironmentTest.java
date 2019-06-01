package com.marekdudek.springcert.environment;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.*;
import org.springframework.test.context.ActiveProfiles;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@SpringBootTest
@ActiveProfiles({"profile-1", "profile-2"})
final class EnvironmentTest
{
    @Autowired
    private Environment environment;
    @Autowired
    private ConfigurableEnvironment configurableEnvironment;


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
    void reading_properties()
    {
        assertThatCode(() ->
                {
                    environment.getRequiredProperty("user.name");
                    environment.getRequiredProperty("HOME");
                    environment.getRequiredProperty("spring.profiles.active");
                }
        ).doesNotThrowAnyException();
    }

    @Test
    void resolving_placeholders()
    {
        assertThatCode(() ->
                environment.resolveRequiredPlaceholders("This is ${spring.application.name} application.")
        ).doesNotThrowAnyException();
    }

    @Test
    void adding_custom_property_source()
    {
        // given
        final ImmutableMap<String, Object> map = ImmutableMap.of("one", 1, "two", 2);
        // when
        final PropertySource<Map<String, Object>> source = new MapPropertySource("map", map);
        final MutablePropertySources sources = configurableEnvironment.getPropertySources();
        sources.addFirst(source);
        // then
        final Integer property = configurableEnvironment.getRequiredProperty("one", Integer.class);
        assertThat(property).isEqualTo(1);
    }
}
