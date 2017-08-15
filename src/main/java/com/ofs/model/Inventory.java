package com.ofs.model;

import lombok.Data;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Map;
import java.util.UUID;

@Data
public class Inventory{

    public Inventory(Map map) {
        this.setId(UUID.fromString((String) map.get("id")));
        this.setHref(URI.create((String) map.get("href")));
        this.setName((String) map.get("name"));
        this.setNotes((String) map.get("notes"));
        this.setPrice(new BigDecimal(map.get("price")+""));
        this.setQuantity((int) map.get("quantity"));
    }

    private UUID id;
    private URI href;
    private String name;
    private String notes;
    private BigDecimal price;
    private int quantity;
}
