package com.ofs.model;

import lombok.Data;

import java.net.URI;
import java.util.UUID;

@Data
public class Customer {
    private UUID id;
    private URI href;
}
