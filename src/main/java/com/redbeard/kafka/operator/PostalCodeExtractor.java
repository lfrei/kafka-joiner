package com.redbeard.kafka.operator;

import com.jayway.jsonpath.JsonPath;
import java.util.function.Function;

public class PostalCodeExtractor implements Function<String, String> {

    @Override
    public String apply(String value) {
        return JsonPath
                .parse(value)
                .read("$.postalCode");
    }
}
