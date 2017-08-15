package com.ofs.model;

import lombok.Data;

import java.net.URI;
import java.util.Map;
import java.util.UUID;

@Data
public class Customer {

    public Customer(Map map) {
        this.setId(UUID.fromString((String) map.get("id")));

        String href = (String) map.get("href");
        this.setHref(href != null ? URI.create(href) : null);
    }

    private UUID id;
    private URI href;
}
