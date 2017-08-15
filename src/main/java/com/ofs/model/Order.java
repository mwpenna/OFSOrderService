package com.ofs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ofs.utils.StringUtils;
import com.ofs.server.model.OFSEntity;
import com.ofs.server.utils.Dates;
import lombok.Data;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.ArrayList;
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
        this.setCompanyId((String) map.get("companyId"));
        this.setDiscountPercent((Double) map.get("discountPercent"));
        this.setTotalPrice((Double) map.get("totalPrice"));
        this.setPriceSubTotal((Double) map.get("priceSubTotal"));
        this.setTaxPercent((Double) map.get("taxPercent"));
        this.setHref(URI.create((String) map.get("href")));

        String createdOn = (String) map.get("createdOn");
        this.setCreatedOn(createdOn != null ? ZonedDateTime.parse(createdOn) : null);

        String updatedOn = (String) map.get("updatedOn");
        this.setUpdatedOn(updatedOn != null ? ZonedDateTime.parse(updatedOn) : null);

        this.setStatus(Status.valueOf((String) map.get("status")));

        List<Inventory> itemList = new ArrayList<>();
        for(Object item : (List) map.get("items")) {
            itemList.add(new Inventory((Map) item));
        }

        List<Shipment> shipmentList = new ArrayList<>();
        for(Object shipment: (List) map.get("shippingDetails")) {
            shipmentList.add(new Shipment((Map) shipment));
        }

        this.setItems(itemList);
        this.setShippingDetails(shipmentList);
        this.setCustomer(new Customer((Map) map.get("customer")));
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
