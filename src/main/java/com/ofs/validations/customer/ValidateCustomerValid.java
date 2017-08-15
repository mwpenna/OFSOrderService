package com.ofs.validations.customer;

import com.ofs.model.Order;
import com.ofs.server.form.update.ChangeSet;
import com.ofs.server.model.OFSErrors;
import com.ofs.service.UserService;
import com.ofs.validations.OrderCreateValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateCustomerValid implements OrderCreateValidation {

    @Autowired
    private UserService userService;

    @Override
    public void validate(Order order, OFSErrors errors) throws Exception {

    }

    @Override
    public void validate(ChangeSet changeSet, Order order, OFSErrors errors) throws Exception {
        validate(order, errors);
    }
}
