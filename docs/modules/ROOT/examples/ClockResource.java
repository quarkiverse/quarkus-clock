import java.time.Clock;
import java.time.Instant;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ClockResource {

    @Inject
    Clock clock;

    public Instant currentInstant() {
        return clock.instant();
    }
}
