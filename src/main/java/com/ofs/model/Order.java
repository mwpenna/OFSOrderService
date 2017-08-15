package com.ofs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ofs.utils.StringUtils;
import com.ofs.server.model.OFSEntity;
import com.ofs.server.utils.Dates;
import lombok.Data;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class Order implements OFSEntity {

    public Order() {

    }

    public Order(URI href) {
        this();
        this.href = href;
        this.createdOn = this.updatedOn = Dates.now();
        this.id = UUID.fromString(this.getIdFromHref());
        this.status = Status.QUOTE;
    }

    public Order(Map map) {
        this.setId(UUID.fromString((String)map.get("id")));
    }

    public enum Status {
        QUOTE,
        APPROVED,
        ON_HOLD,
        IN_BACKORDER,
        IN_PROGRESS,
        SHIPPED,
        DELIVERED,
        CLOSED
    }

    private UUID id;
    private URI href;
    private ZonedDateTime updatedOn;
    private ZonedDateTime createdOn;
    private List<Shipment> shippingDetails;
    private List<Inventory> items;
    private Status status;
    private double priceSubTotal;
    private double taxPercent;
    private double totalPrice;
    private double discountPercent;
    private Customer customer;
    private String companyId;

    @JsonIgnore
    public String getIdFromHref() {
        return StringUtils.getIdFromURI(getHref());
    }
}
