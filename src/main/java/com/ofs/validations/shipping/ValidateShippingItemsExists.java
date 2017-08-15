package com.ofs.validations.shipping;

import com.ofs.model.Inventory;
import com.ofs.model.Order;
import com.ofs.server.form.update.ChangeSet;
import com.ofs.server.model.OFSErrors;
import com.ofs.validations.OrderCreateValidation;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ValidateShippingItemsExists implements OrderCreateValidation {

    @Override
    public void validate(Order order, OFSErrors errors) throws Exception {
        Map<UUID, Inventory> inventoryMap = order.getItems().stream().collect(Collectors.toMap(Inventory::getId, Function.identity()));

        if(order.getShippingDetails() != null) {
            order.getShippingDetails().forEach(shipment -> {
                shipment.getItemsInShipment().forEach(inventory -> {
                    if(!inventoryMap.containsKey(inventory.getId())) {
                        errors.rejectValue("order.shipment.inventory.id","Shipment inventory id does not exists in the order.");
                    }
                });
            });
        }
    }

    @Override
    public void validate(ChangeSet changeSet, Order order, OFSErrors errors) throws Exception {
        validate(order, errors);
    }
}
