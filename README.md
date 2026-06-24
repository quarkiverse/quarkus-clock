# Quarkus Clock

[![Version](https://img.shields.io/maven-central/v/io.quarkiverse.quarkus-clock/quarkus-clock?logo=apache-maven&style=flat-square)](https://central.sonatype.com/artifact/io.quarkiverse.quarkus-clock/quarkus-clock)
[![License](https://img.shields.io/badge/License-Apache%202.0-yellow.svg?style=flat-square)](https://opensource.org/licenses/Apache-2.0)
[![Build](https://github.com/quarkiverse/quarkus-clock/actions/workflows/build.yml/badge.svg)](https://github.com/quarkiverse/quarkus-clock/actions/workflows/build.yml)

A Quarkus extension that provides an injectable `java.time.Clock` for your application.
Using a CDI-managed clock instead of calling `Instant.now()` directly makes time-dependent logic easier to test and control in development.

Supported clock modes:

* `system` (default) — JVM system clock
* `fixed` — constant instant for deterministic tests
* `adjustable` — mutable clock you can advance or reset at runtime

## Documentation

Read the full [Quarkus Clock guide](https://docs.quarkiverse.io/quarkus-clock/dev/).

## Installation

### Maven

```xml
<dependency>
    <groupId>io.quarkiverse.quarkus-clock</groupId>
    <artifactId>quarkus-clock</artifactId>
    <version>0.1.0</version>
</dependency>
```

### Gradle

```kotlin
dependencies {
    implementation("io.quarkiverse.quarkus-clock:quarkus-clock:0.1.0")
}
```

## Usage

```java
@ApplicationScoped
public class OrderService {

    @Inject
    Clock clock;

    public boolean isExpired(Instant deadline) {
        return clock.instant().isAfter(deadline);
    }
}
```

Configure a fixed clock for tests:

```properties
%test.quarkus.clock.type=fixed
%test.quarkus.clock.fixed-instant=2000-01-01T00:00:00Z
```

See the [documentation](https://docs.quarkiverse.io/quarkus-clock/dev/) for adjustable clocks, configuration reference, and testing patterns.

## Contributing

Contributions are welcome. Please read [CONTRIBUTING.md](CONTRIBUTING.md) and our [Code of Conduct](CODE_OF_CONDUCT.md) before opening a pull request.

* [Report an issue](https://github.com/quarkiverse/quarkus-clock/issues)
* [Open a pull request](https://github.com/quarkiverse/quarkus-clock/pulls)

## License

This project is licensed under the [Apache License 2.0](LICENSE).
