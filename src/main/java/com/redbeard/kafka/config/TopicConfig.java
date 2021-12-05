package com.redbeard.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    @Bean
    NewTopic addressTopic() {
        return TopicBuilder.name("address")
                .partitions(5)
                .replicas(1)
                .build();
    }

    @Bean
    NewTopic postalCodeTopic() {
        return TopicBuilder.name("postal-code")
                .partitions(5)
                .replicas(1)
                .build();
    }

    @Bean
    NewTopic deliverAddressTopic() {
        return TopicBuilder.name("delivery-address")
                .partitions(5)
                .replicas(1)
                .build();
    }
}
