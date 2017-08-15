package com.ofs.service;

import com.ofs.client.InventoryServiceClient;
import com.ofs.model.inventoryservice.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InventoryService {

    @Autowired
    private InventoryServiceClient inventoryServiceClient;

    public Optional<Inventory> getInventoryById(String id) {
        return inventoryServiceClient.getInventoryById(id);
    }
}
