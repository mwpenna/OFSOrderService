package com.ofs.client;

import com.ofs.model.inventoryservice.Inventory;
import com.ofs.server.security.SecurityContext;
import com.ofs.server.security.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.Optional;

@Component
public class InventoryServiceClient extends BaseRestClient<Inventory> {

    @Value("${inventoryServiceBaseURL}")
    private String inventoryServiceBaseURL;

    public Optional<Inventory> getInventoryById(String id) {
        Subject subject = SecurityContext.getSubject();
        URI requestUri = URI.create(inventoryServiceBaseURL + "/inventory/id/" + id);
        HttpHeaders headers = this.getHeaders("Bearer " + subject.getToken());
        RequestEntity request = new RequestEntity(headers, HttpMethod.GET, requestUri);
        return Optional.of(this.sendRequest(request, Inventory.class));
    }
}
