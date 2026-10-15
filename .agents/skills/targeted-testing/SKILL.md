---
name: targeted-testing
description: Strict guidelines for local test execution in Flinkboot. Enforces module and test-class targeting, fast feedback loops, and delegates repository-wide verification to CI.
---

# Targeted Testing

## Rationale & Philosophy

Flinkboot is a multi-module repository with decoupled modules (`flinkboot-core`, `flinkboot-kafka`, `flinkboot-fluss`, `flinkboot-test`).
Running full repository test runs (`mvn test` across all modules) locally wastes time, CPU, and developer focus.

- **Local Execution (Agent & Developer)**: Surgical, fast, and targeted (< 10 seconds). Verify only touched code and direct contracts.
- **Continuous Integration (CI)**: Exhaustive and defensive. GitHub Actions runs the complete test matrix across operating systems (Linux, Windows).

---

## Strict Rules

1. **Never Run Global Tests Locally**:
   - Never execute `mvn test`, `mvn clean test`, or `mvn verify` at the repository root without targeting flags.
   - Always restrict test execution to the touched module via `-pl <module>`.

2. **Always Target by Module (`-pl`)**:
   - Restrict tests to the module containing the modifications:
     ```bash
     mvn test -pl flinkboot-kafka
     ```

3. **Target by Test Class During Iterative Work (`-Dtest`)**:
   - When writing, fixing, or verifying a specific feature, run only its dedicated test class:
     ```bash
     mvn test -pl flinkboot-kafka -Dtest=KafkaSinkPropertiesTest
     ```
   - Target a specific test method when debugging an isolated regression:
     ```bash
     mvn test -pl flinkboot-kafka -Dtest=KafkaSinkPropertiesTest#shouldFailWhenDeliveryGuaranteeIsNull
     ```

4. **Avoid Gratuitous `clean`**:
   - Do not use `mvn clean test` systematically. Incremental compilation saves significant execution time and turn duration.
   - Use `clean` only when experiencing stale bytecode issues or major module refactorings.

5. **Managing `flinkboot-core` Changes**:
   - When modifying `flinkboot-core`, test `flinkboot-core` first:
     ```bash
     mvn test -pl flinkboot-core
     ```
   - Then test only the specific downstream module affected by the change (e.g. `flinkboot-kafka`).
