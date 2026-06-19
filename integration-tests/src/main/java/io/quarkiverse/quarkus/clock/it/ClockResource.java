package io.quarkiverse.quarkus.clock.it;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

import io.quarkiverse.quarkus.clock.AdjustableClock;
import io.quarkus.arc.ClientProxy;

@Path("/clock")
@ApplicationScoped
public class ClockResource {

    @Inject
    Clock clock;

    @GET
    @Path("/now")
    public String now() {
        return clock.instant().toString();
    }

    @POST
    @Path("/forward")
    public String forward(@QueryParam("seconds") long seconds) {
        if (ClientProxy.unwrap(clock) instanceof AdjustableClock adjustable) {
            adjustable.forward(Duration.ofSeconds(seconds));
            return clock.instant().toString();
        }
        return "Clock is not adjustable";
    }

    @POST
    @Path("/set")
    public String set(@QueryParam("instant") String instant) {
        if (ClientProxy.unwrap(clock) instanceof AdjustableClock adjustable) {
            adjustable.travelTo(Instant.parse(instant));
            return clock.instant().toString();
        }
        return "Clock is not adjustable";
    }
}
