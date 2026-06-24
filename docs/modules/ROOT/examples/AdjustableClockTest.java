import java.util.Map;

import io.quarkus.test.junit.QuarkusTestProfile;

public class AdjustableClockTest {

    public static class AdjustableProfile implements QuarkusTestProfile {

        @Override
        public Map<String, String> getConfigOverrides() {
            return Map.of("quarkus.clock.type", "adjustable");
        }
    }
}
