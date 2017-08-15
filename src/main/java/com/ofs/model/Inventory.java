package com.ofs.model;

import lombok.Data;

import java.math.BigDecimal;
import java.net.URI;
import java.util.UUID;

@Data
public class Inventory{
    private UUID id;
    private URI href;
    private String name;
    private String notes;
    private BigDecimal price;
    private int quantity;
}
