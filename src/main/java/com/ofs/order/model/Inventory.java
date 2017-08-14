package com.ofs.order.model;

import lombok.Data;

import java.net.URI;
import java.util.UUID;

@Data
public class Inventory{
    private UUID id;
    private URI href;
    private String name;
    private String notes;
    private double price;
    private int quantity;
}
