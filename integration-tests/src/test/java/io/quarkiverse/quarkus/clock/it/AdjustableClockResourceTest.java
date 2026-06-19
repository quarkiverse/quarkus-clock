package io.quarkiverse.quarkus.clock.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.util.Map;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.QuarkusTestProfile;
import io.quarkus.test.junit.TestProfile;

@QuarkusTest
@TestProfile(AdjustableClockResourceTest.AdjustableProfile.class)
public class AdjustableClockResourceTest {

    public static class AdjustableProfile implements QuarkusTestProfile {
        @Override
        public Map<String, String> getConfigOverrides() {
            return Map.of("quarkus.clock.type", "adjustable");
        }
    }

    @Test
    public void testForwardMovesTime() {
        String before = given().when().get("/clock/now").then().statusCode(200).extract().body().asString();

        given()
                .when().post("/clock/forward?seconds=3600")
                .then()
                .statusCode(200)
                .body(not(before));
    }

    @Test
    public void testSetTravelsToInstant() {
        given()
                .when().post("/clock/set?instant=2000-01-01T00:00:00Z")
                .then()
                .statusCode(200)
                .body(is("2000-01-01T00:00:00Z"));
    }
}
