package com.ofs.validations.inventory;

import com.ofs.model.Order;
import com.ofs.model.inventoryservice.Inventory;
import com.ofs.server.form.update.ChangeSet;
import com.ofs.server.model.OFSErrors;
import com.ofs.service.InventoryService;
import com.ofs.validations.OrderCreateValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class ValidateInventoryValid implements OrderCreateValidation {

    @Autowired
    private InventoryService inventoryService;

    @Override
    public void validate(Order order, OFSErrors errors) throws Exception {

        order.getItems().forEach(inventory -> {
            Optional<Inventory> inventoryOptional = inventoryService.getInventoryById(inventory.getId().toString());

            if(inventoryOptional.isPresent()) {
                Inventory inventoryItem = inventoryOptional.get();
                inventory.setName(inventoryItem.getName());
                inventory.setHref(inventoryItem.getHref());

                if(inventory.getPrice() == null) {
                    inventory.setPrice(new BigDecimal(inventoryItem.getPrice()+""));
                }
            }
            else {
                errors.rejectValue("order.items.id","Order inventory item does not exists for company.");
            }
        });
    }

    @Override
    public void validate(ChangeSet changeSet, Order order, OFSErrors errors) throws Exception {
        validate(order, errors);
    }
}
