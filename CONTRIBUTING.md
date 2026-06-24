# Contributing to Quarkus Clock

Thank you for your interest in contributing! This document covers the essentials for getting started.

## Prerequisites

* JDK 17 or later
* Maven 3.8.6 or later

## Workflow

1. [Fork the repository](https://github.com/quarkiverse/quarkus-clock/fork)
2. Clone your fork locally
3. Create a branch from `main`
4. Make your changes
5. Run the build and tests (see below)
6. Open a pull request against `main`

Direct pushes to `main` are blocked by branch protection rules.

Keep your fork up to date with the upstream repository:

```bash
git remote add upstream https://github.com/quarkiverse/quarkus-clock.git
git fetch upstream
git rebase upstream/main
```

## Build

Full build with tests:

```bash
mvn clean install
```

Build documentation:

```bash
mvn -pl docs package
```

Native integration tests (optional):

```bash
mvn clean install -Dnative -Dquarkus.native.container-build -Dnative.surefire.skip
```

## Tests

* Unit tests live in the `deployment/` module
* Integration tests live in the `integration-tests/` module

Run the full test suite with `mvn clean install` before opening a pull request.

## Documentation

User-facing documentation is maintained with Antora under `docs/`.
Update the relevant pages when changing configuration or public API behavior.

## Code style

This project uses the Quarkus code style via `quarkiverse-parent` (Eclipse formatter + import order).

Before opening a pull request:

```bash
mvn process-sources
mvn clean install
```

IDE setup: see [Quarkus CONTRIBUTING — IDE config and code style](https://github.com/quarkusio/quarkus/blob/main/CONTRIBUTING.md#ide-config-and-code-style).
Formatter files (`eclipse-format.xml` and `eclipse.importorder`) come from `io.quarkus:quarkus-ide-config` in your local Maven repository after the first build.

### Coding guidelines

* No `@author` Javadoc tags — use Git history instead
* Prefer meaningful, atomic commits; squash fixups before merge if asked
* Update tests and Antora docs when changing behavior or configuration

## Commits and license

* Write clear, atomic commit messages
* Contributions are licensed under the [Apache License 2.0](LICENSE)
* Consider adding a DCO sign-off to commit messages (`Signed-off-by: Your Name <email@example.com>`) — see the [Developer Certificate of Origin](https://developercertificate.org/)

## Community

* [Quarkiverse wiki](https://github.com/quarkiverse/quarkiverse/wiki) — organization policies and conventions
* [Code of Conduct](CODE_OF_CONDUCT.md)
