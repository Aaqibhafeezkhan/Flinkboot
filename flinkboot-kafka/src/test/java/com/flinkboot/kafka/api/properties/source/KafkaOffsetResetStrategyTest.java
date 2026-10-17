package com.flinkboot.kafka.api.properties.source;

import org.apache.kafka.clients.consumer.OffsetResetStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("KafkaOffsetResetStrategy")
class KafkaOffsetResetStrategyTest {

    @Nested
    @DisplayName("OffsetResetStrategy Resolution")
    class OffsetResetStrategyResolution {

        @ParameterizedTest
        @CsvSource({
            "EARLIEST, EARLIEST",
            "LATEST,   LATEST",
            "NONE,     NONE"
        })
        @DisplayName("Should configure correct Kafka OffsetResetStrategy mapping")
        void shouldMapToKafkaOffsetResetStrategy(
            KafkaOffsetResetStrategy flinkbootStrategy,
            OffsetResetStrategy expectedKafkaStrategy
        ) {
            assertEquals(expectedKafkaStrategy, flinkbootStrategy.offsetResetStrategy());
        }
    }
}
