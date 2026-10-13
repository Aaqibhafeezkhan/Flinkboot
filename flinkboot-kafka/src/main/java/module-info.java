module com.flinkboot.kafka {
    requires transitive com.flinkboot.core;
    requires kafka.clients;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires jakarta.validation;

    exports com.flinkboot.kafka.api.properties.source;
    exports com.flinkboot.kafka.api.properties.sink;
    exports com.flinkboot.kafka.api.source;
    exports com.flinkboot.kafka.api.sink;

    opens com.flinkboot.kafka.api.properties.source;
    opens com.flinkboot.kafka.api.properties.sink;
    opens com.flinkboot.kafka.internal.validation.properties to org.junit.platform.commons;
}
