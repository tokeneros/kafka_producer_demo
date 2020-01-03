package com.kafka.example.demo.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: eros
 * @Description:
 * @Date: Created in 2020/1/2 15:01
 * @Version: 1.0
 * @Modified By:
 */
@Component
@ConfigurationProperties(prefix = KafkaProperties.PREFIX)
@Data
public class KafkaProperties {

    public static final String PREFIX = "spring.kafka.producer";

    private String bootstrapServers;

    private String retries;

    private String batchSize;

    private String bufferMemory;

    private String keySerializer;

    private String valueSerializer;

}
