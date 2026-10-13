module com.flinkboot.test {
    requires transitive org.junit.jupiter.api;

    exports com.flinkboot.test.api.assertion;
    exports com.flinkboot.test.api.assertion.type;
    exports com.flinkboot.test.api.sink;

    opens com.flinkboot.test.api.sink;
}
