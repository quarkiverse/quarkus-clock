import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import io.quarkiverse.clock.AdjustableClock;
import io.quarkus.arc.ClientProxy;

@ApplicationScoped
public class AdjustableClockExample {

    @Inject
    Clock clock;

    public Instant forwardOneHour() {
        if (ClientProxy.unwrap(clock) instanceof AdjustableClock adjustable) {
            adjustable.forward(Duration.ofHours(1));
        }
        return clock.instant();
    }

    public Instant travelTo(Instant instant) {
        if (ClientProxy.unwrap(clock) instanceof AdjustableClock adjustable) {
            adjustable.travelTo(instant);
        }
        return clock.instant();
    }
}
