package com.ofs.model;

import lombok.Data;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class Shipment {

    public Shipment(Map map) {
        this.setId(UUID.fromString((String) map.get("id")));

        String href = (String) map.get("href");
        this.setHref(href != null ? URI.create(href) : null);

        String createdOn = (String) map.get("createdOn");
        this.setCreatedOn(createdOn != null ? ZonedDateTime.parse(createdOn) : null);

        String updatedOn = (String) map.get("updatedOn");
        this.setUpdatedOn(updatedOn != null ? ZonedDateTime.parse(updatedOn) : null);

        String shippedDate = (String) map.get("shippedDate");
        this.setShippedDate(shippedDate != null ? ZonedDateTime.parse(shippedDate) : null);

        String estimatedArrivalDate = (String) map.get("estimatedArrivalDate");
        this.setEstimatedArrivalDate(estimatedArrivalDate != null ? ZonedDateTime.parse(estimatedArrivalDate) : null);

        this.setTrackingID((String) map.get("trackingID"));
        this.setCarrier((String) map.get("carrier"));

        List<Inventory> itemList = new ArrayList<>();
        for(Object item : (List) map.get("itemsInShipment")) {
            itemList.add(new Inventory((Map) item));
        }

        this.setItemsInShipment(itemList);
    }

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
