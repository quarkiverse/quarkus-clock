package io.quarkiverse.quarkus.clock.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ClockResourceTest {

    @Test
    public void testNowEndpoint() {
        given()
                .when().get("/clock/now")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }
}
