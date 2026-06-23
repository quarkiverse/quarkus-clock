package io.quarkiverse.quarkus.clock;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class ClockProducer {

    private final ClockType type;
    private final Optional<String> fixedInstant;

    ClockProducer(
            @ConfigProperty(name = "quarkus.clock.type", defaultValue = "system") ClockType type,
            @ConfigProperty(name = "quarkus.clock.fixed-instant") Optional<String> fixedInstant) {
        this.type = type;
        this.fixedInstant = fixedInstant;
    }

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
