package com.ofs.model.userservice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.ofs.server.filter.views.SystemAdmin;
import com.ofs.server.model.OFSEntity;
import com.ofs.server.security.Subject;
import com.ofs.server.utils.Dates;
import com.ofs.utils.StringUtils;
import lombok.Data;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.UUID;

@Data
public class User {

    public enum Role {
        SYSTEM_ADMIN,
        ADMIN,
        ACCOUNT_MANAGER,
        WAREHOUSE,
        CUSTOMER
    }

    private UUID id;
    private String firstName;
    private String lastName;
    private Company company;
    private Role role;
    private String userName;
    private String emailAddress;
    private boolean activeFlag = true;
    private URI href;
    private ZonedDateTime createdOn;
    private ZonedDateTime tokenExpDate;
    private String token;
    private String password;

    @JsonIgnore
    public String getIdFromHref() {
        return StringUtils.getIdFromURI(getHref());
    }
}
