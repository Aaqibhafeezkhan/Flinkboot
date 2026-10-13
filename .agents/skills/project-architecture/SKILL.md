---
name: project-architecture
description: Rules for structuring packages, modules, and public vs internal APIs in Flinkboot.
---

# Architecture Choice

The project follows a **Package-by-Feature (Vertical Slice Architecture)** combined with a strict **KISS (Keep It Simple, Stupid)** approach and clean **JPMS Modularization**.

# Package Organization

Packages must describe business features and domain capabilities, never technical layers.

## Standard Package Layout for Modules (`flinkboot-*`)

Each submodule (e.g. `flinkboot-core`, `flinkboot-kafka`, `flinkboot-fluss`) follows this standard structure:

- **Public APIs (`*.api.*`)**:
  - `com.flinkboot.<module>.api`: Main entry points and interfaces.
  - `com.flinkboot.<module>.api.properties.<feature>`: Configuration properties DTOs (e.g. `source`, `sink`, `checkpointing`).
  - `com.flinkboot.<module>.api.<feature>`: Domain factories and builders (e.g. `FlussSourceFactory`, `KafkaSinkFactory`).
  - `com.flinkboot.<module>.api.exception`: Specific domain and configuration exceptions.
- **Internal Implementations (`*.internal.*`)**:
  - `com.flinkboot.<module>.internal.*`: Private machinery, internal utilities, annotations (never exported to consumers in `module-info.java`).

## JPMS Module Descriptor Rules (`module-info.java`)

1. **Exports**: Export all `*.api.*` packages containing public classes and interfaces.
2. **Opens**: Open all `*.api.properties.*` packages to reflection (`com.fasterxml.jackson.databind`, `org.hibernate.validator` / `jakarta.validation`).
3. **Internal encapsulation**: Never export or open `*.internal.*` packages.