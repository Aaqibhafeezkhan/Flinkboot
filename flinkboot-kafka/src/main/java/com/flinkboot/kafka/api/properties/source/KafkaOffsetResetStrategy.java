package com.flinkboot.kafka.api.properties.source;

import org.apache.kafka.clients.consumer.OffsetResetStrategy;

import java.util.Objects;

/**
 * Reset strategy for partitions without explicit offsets when specific offsets are configured.
 */
public enum KafkaOffsetResetStrategy {

    /**
     * Automatically reset the offset to the earliest offset.
     */
    EARLIEST(OffsetResetStrategy.EARLIEST),

    /**
     * Automatically reset the offset to the latest offset.
     */
    LATEST(OffsetResetStrategy.LATEST),

    /**
     * Throw exception to the consumer if no previous offset is found for the consumer's group.
     */
    NONE(OffsetResetStrategy.NONE);

    private final OffsetResetStrategy offsetResetStrategy;

    KafkaOffsetResetStrategy(OffsetResetStrategy offsetResetStrategy) {
        this.offsetResetStrategy = Objects.requireNonNull(offsetResetStrategy, "offsetResetStrategy must not be null");
    }

    /**
     * Returns the underlying Kafka {@link OffsetResetStrategy}.
     *
     * @return the {@link OffsetResetStrategy}
     */
    public OffsetResetStrategy offsetResetStrategy() {
        return offsetResetStrategy;
    }
}
