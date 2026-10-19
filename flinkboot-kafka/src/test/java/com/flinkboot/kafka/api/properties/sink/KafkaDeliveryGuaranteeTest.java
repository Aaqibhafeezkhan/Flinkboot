package com.flinkboot.kafka.api.properties.sink;

import org.apache.flink.connector.base.DeliveryGuarantee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("KafkaDeliveryGuarantee")
class KafkaDeliveryGuaranteeTest {

    @Test
    @DisplayName("Should map each Kafka delivery guarantee to the corresponding Flink guarantee")
    void shouldMapToFlinkDeliveryGuarantee() {
        assertAll(
            () -> assertEquals(DeliveryGuarantee.EXACTLY_ONCE,
                KafkaDeliveryGuarantee.EXACTLY_ONCE.deliveryGuarantee()),
            () -> assertEquals(DeliveryGuarantee.AT_LEAST_ONCE,
                KafkaDeliveryGuarantee.AT_LEAST_ONCE.deliveryGuarantee()),
            () -> assertEquals(DeliveryGuarantee.NONE,
                KafkaDeliveryGuarantee.NONE.deliveryGuarantee())
        );
    }
}
