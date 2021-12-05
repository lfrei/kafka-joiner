package com.redbeard.kafka.operator;

import com.jayway.jsonpath.JsonPath;
import org.apache.kafka.streams.kstream.ValueJoiner;

public class AddressJoiner implements ValueJoiner<String, String, String> {

    @Override
    public String apply(String address, String postalCode) {
        return JsonPath
                .parse(address)
                .put("$", "town", getTown(postalCode))
                .jsonString();
    }

    private String getTown(String postalCode) {
        return JsonPath
                .parse(postalCode)
                .read("$.town");
    }
}
