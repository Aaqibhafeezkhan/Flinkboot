package com.flinkboot.core.internal.execution.customizer;

import com.flinkboot.core.api.properties.ExecutionEnvironmentProperties;

public interface EnvironmentCustomizer {

    void configure(ExecutionEnvironmentProperties configuration);

}
