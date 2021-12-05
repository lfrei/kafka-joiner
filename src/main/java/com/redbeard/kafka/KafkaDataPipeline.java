package com.redbeard.kafka;

import com.redbeard.kafka.operator.PostalCodeExtractor;
import com.redbeard.kafka.operator.AddressJoiner;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Named;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.BiFunction;

@Configuration
public class KafkaDataPipeline {

    @Bean
    public BiFunction<KTable<String, String>, KTable<String, String>, KStream<String, String>> process() {

        return (address, postalCode) -> address
                .leftJoin(postalCode,
                        new PostalCodeExtractor(),
                        new AddressJoiner(),
                        Named.as("address-postal-code-join"),
                        Materialized.as("address-postal-code-store"))
                .toStream(Named.as("delivery-address"));
    }
}
