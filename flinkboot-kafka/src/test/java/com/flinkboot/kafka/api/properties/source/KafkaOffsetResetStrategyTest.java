package com.flinkboot.kafka.api.properties.source;

import org.apache.kafka.clients.consumer.OffsetResetStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("KafkaOffsetResetStrategy")
class KafkaOffsetResetStrategyTest {

    @Nested
    @DisplayName("OffsetResetStrategy Resolution")
    class OffsetResetStrategyResolution {

        @Test
        @DisplayName("Should configure correct Kafka OffsetResetStrategy mapping")
        void shouldMapToKafkaOffsetResetStrategy() {
            assertAll(
                () -> assertEquals(OffsetResetStrategy.EARLIEST, KafkaOffsetResetStrategy.EARLIEST.offsetResetStrategy()),
                () -> assertEquals(OffsetResetStrategy.LATEST, KafkaOffsetResetStrategy.LATEST.offsetResetStrategy()),
                () -> assertEquals(OffsetResetStrategy.NONE, KafkaOffsetResetStrategy.NONE.offsetResetStrategy())
            );
        }
    }
}
