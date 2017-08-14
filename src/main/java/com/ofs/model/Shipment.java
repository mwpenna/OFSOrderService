package com.ofs.order.model;

import lombok.Data;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class Shipment {
    private UUID id;
    private URI href;
    private ZonedDateTime createdOn;
    private ZonedDateTime updatedOn;
    private ZonedDateTime shippedDate;
    private ZonedDateTime estimatedArrivalDate;
    private String trackingID;
    private String carrier;
    private List<Inventory> itemsInShipment;
}
