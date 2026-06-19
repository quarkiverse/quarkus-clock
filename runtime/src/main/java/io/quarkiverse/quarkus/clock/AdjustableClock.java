package io.quarkiverse.quarkus.clock;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.concurrent.atomic.AtomicReference;

public class AdjustableClock extends Clock {

    private final AtomicReference<Instant> instant;
    private final ZoneId zone;

    public AdjustableClock() {
        this(Instant.now(), ZoneOffset.UTC);
    }

    public AdjustableClock(Instant base, ZoneId zone) {
        this.instant = new AtomicReference<>(base);
        this.zone = zone;
    }

    public void fixTo(Instant newInstant) {
        instant.set(newInstant);
    }

    public void forward(Duration duration) {
        instant.updateAndGet(i -> i.plus(duration));
    }

    public void travelTo(Instant newInstant) {
        instant.set(newInstant);
    }

    public void reset() {
        instant.set(Instant.now());
    }

    @Override
    public ZoneId getZone() {
        return zone;
    }

    @Override
    public Clock withZone(ZoneId newZone) {
        return new AdjustableClock(instant.get(), newZone);
    }

    @Override
    public Instant instant() {
        return instant.get();
    }
}
