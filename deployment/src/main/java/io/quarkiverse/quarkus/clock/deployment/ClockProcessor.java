package io.quarkiverse.quarkus.clock.deployment;

import io.quarkiverse.quarkus.clock.ClockProducer;
import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;

class ClockProcessor {

    private static final String FEATURE = "clock";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    AdditionalBeanBuildItem beans() {
        return AdditionalBeanBuildItem.unremovableOf(ClockProducer.class);
    }
}
