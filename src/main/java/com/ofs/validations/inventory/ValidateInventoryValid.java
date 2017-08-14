package com.ofs.validations.inventory;

import com.ofs.model.Order;
import com.ofs.server.form.update.ChangeSet;
import com.ofs.server.model.OFSErrors;
import com.ofs.validations.OrderCreateValidation;
import org.springframework.stereotype.Component;

@Component
public class ValidateInventoryValid implements OrderCreateValidation {
    @Override
    public void validate(Order order, OFSErrors errors) throws Exception {

    }

    @Override
    public void validate(ChangeSet changeSet, Order order, OFSErrors errors) throws Exception {
        validate(order, errors);
    }
}
