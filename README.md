# Quarkus Clock

[![Version](https://img.shields.io/maven-central/v/io.quarkiverse.clock/quarkus-clock?logo=apache-maven&style=flat-square)](https://central.sonatype.com/artifact/io.quarkiverse.clock/quarkus-clock-parent)
[![Build](https://github.com/quarkiverse/quarkus-clock/actions/workflows/build.yml/badge.svg)](https://github.com/quarkiverse/quarkus-clock/actions/workflows/build.yml)

Injectable `java.time.Clock` for Quarkus applications: the system clock by default, a fixed instant for deterministic tests, or an adjustable clock you can move in tests and development.

## Installation

Maven:

```xml
<dependency>
    <groupId>io.quarkiverse.clock</groupId>
    <artifactId>quarkus-clock</artifactId>
    <version>${quarkus-clock.version}</version>
</dependency>
```

Gradle:

```groovy
implementation("io.quarkiverse.clock:quarkus-clock:${quarkusClockVersion}")
```

## Documentation

User guide (Antora): see the `docs/` directory.
Once this repository is registered in [quarkiverse-docs](https://github.com/quarkiverse/quarkiverse-docs), the guide is published at <https://docs.quarkiverse.io/quarkus-clock/dev/>.

## Contributing

See the [Quarkiverse wiki](https://github.com/quarkiverse/quarkiverse/wiki) and [Quarkus CONTRIBUTING](https://github.com/quarkusio/quarkus/blob/main/CONTRIBUTING.md) for code style and workflow.

Build with format validation, the same way the Build workflow does:

```bash
mvn -B clean install -Dno-format
```

## License

Licensed under the [Apache License 2.0](LICENSE).
