import java.time.Clock;
import java.time.Instant;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class InjectClockExample {

    @Inject
    Clock clock;

    public Instant now() {
        return clock.instant();
    }
}
