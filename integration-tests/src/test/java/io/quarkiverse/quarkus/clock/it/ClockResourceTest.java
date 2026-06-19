package io.quarkiverse.quarkus.clock.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ClockResourceTest {

    @Test
    public void testNowReturnsFixedInstant() {
        given()
                .when().get("/clock/now")
                .then()
                .statusCode(200)
                .body(is("2000-01-01T00:00:00Z"));
    }
}
