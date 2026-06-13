package io.quarkiverse.quarkus.clock;

import java.util.Optional;

import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

@ConfigMapping(prefix = "quarkus.clock")
@ConfigRoot
public interface ClockConfig {

    /**
     * The clock implementation to use.
     * Supported values: {@code system}, {@code fixed}, {@code adjustable}.
     */
    @WithDefault("system")
    ClockType type();

    /**
     * The fixed instant to use when {@code quarkus.clock.type=fixed}.
     * Must be a valid ISO-8601 instant string, e.g. {@code 2000-01-01T00:00:00Z}.
     */
    Optional<String> fixedInstant();
}
