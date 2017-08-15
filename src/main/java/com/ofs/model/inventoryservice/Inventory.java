package com.ofs.model.inventoryservice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ofs.server.model.OFSEntity;
import com.ofs.server.utils.Dates;
import com.ofs.utils.StringUtils;
import lombok.Data;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class Inventory {

    private UUID id;
    private URI href;
    private ZonedDateTime createdOn;
    private String type;
    private List<Props> props;
    private String companyId;
    private int quantity;
    private String name;
    private String description;
    private double price;

    @JsonIgnore
    public String getIdFromHref() {
        return StringUtils.getIdFromURI(getHref());
    }
}
