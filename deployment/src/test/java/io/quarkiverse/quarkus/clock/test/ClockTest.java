package io.quarkiverse.quarkus.clock.test;

import java.time.Clock;
import java.time.Instant;

import jakarta.inject.Inject;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.quarkus.test.QuarkusExtensionTest;

public class ClockTest {

    @RegisterExtension
    static final QuarkusExtensionTest unitTest = new QuarkusExtensionTest()
            .setArchiveProducer(() -> ShrinkWrap.create(JavaArchive.class))
            .overrideConfigKey("quarkus.clock.type", "fixed")
            .overrideConfigKey("quarkus.clock.fixed-instant", "2000-01-01T00:00:00Z");

    @Inject
    Clock clock;

    @Test
    public void testFixedClockInstant() {
        Assertions.assertEquals(Instant.parse("2000-01-01T00:00:00Z"), clock.instant());
    }
}
