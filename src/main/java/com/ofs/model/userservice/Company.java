package com.ofs.model.userservice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ofs.server.model.BaseOFSEntity;
import com.ofs.utils.StringUtils;
import lombok.Data;

import java.net.URI;
import java.util.Map;
import java.util.UUID;

@Data
public class Company extends BaseOFSEntity {

    private String name;
    private UUID id;

    public Company() {

    }

    @JsonIgnore
    public String getIdFromHref() {
        return StringUtils.getIdFromURI(getHref());
    }
}
