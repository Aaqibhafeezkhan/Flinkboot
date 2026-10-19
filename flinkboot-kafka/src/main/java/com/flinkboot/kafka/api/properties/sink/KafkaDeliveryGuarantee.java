package com.flinkboot.kafka.api.properties.sink;

import org.apache.flink.connector.base.DeliveryGuarantee;

/**
 * Delivery consistency guarantee semantics for Kafka sink producers.
 */
public enum KafkaDeliveryGuarantee {
    /**
     * Exactly-once semantic guarantee using Kafka transactions.
     */
    EXACTLY_ONCE(DeliveryGuarantee.EXACTLY_ONCE),
    /**
     * At-least-once semantic guarantee with checkpointed message acknowledgments.
     */
    AT_LEAST_ONCE(DeliveryGuarantee.AT_LEAST_ONCE),
    /**
     * No delivery guarantee (at-most-once / best effort fire-and-forget).
     */
    NONE(DeliveryGuarantee.NONE);

    private final DeliveryGuarantee deliveryGuarantee;

    KafkaDeliveryGuarantee(DeliveryGuarantee deliveryGuarantee) {
        this.deliveryGuarantee = deliveryGuarantee;
    }

    /**
     * Returns the corresponding Flink {@link DeliveryGuarantee}.
     *
     * @return the {@link DeliveryGuarantee} enum value
     */
    public DeliveryGuarantee deliveryGuarantee() {
        return deliveryGuarantee;
    }
}
