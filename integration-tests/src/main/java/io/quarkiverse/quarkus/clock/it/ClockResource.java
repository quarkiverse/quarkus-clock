package io.quarkiverse.quarkus.clock.it;

import java.time.Clock;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

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
}
