package io.quarkiverse.quarkus.clock;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class ClockProducer {

    @Inject
    @ConfigProperty(name = "quarkus.clock.type", defaultValue = "system")
    ClockType type;

    @Inject
    @ConfigProperty(name = "quarkus.clock.fixed-instant")
    Optional<String> fixedInstant;

    @Produces
    @ApplicationScoped
    public Clock clock() {
        return switch (type) {
            case FIXED -> Clock.fixed(
                    Instant.parse(fixedInstant
                            .orElseThrow(() -> new IllegalStateException(
                                    "quarkus.clock.fixed-instant must be set when quarkus.clock.type=fixed"))),
                    ZoneOffset.UTC);
            case ADJUSTABLE -> new AdjustableClock();
            default -> Clock.systemUTC();
        };
    }
}
