package com.ofs.validators;

import com.ofs.model.Order;
import com.ofs.server.errors.BadRequestException;
import com.ofs.server.form.update.ChangeSet;
import com.ofs.server.model.OFSErrors;
import com.ofs.validations.OrderCreateValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderCreateValidator implements Validator<Order> {

    private final List<OrderCreateValidation> VALIDATIONS = new ArrayList<>();

    @Autowired
    public OrderCreateValidator(List<OrderCreateValidation> validations) {
        validations.forEach(validation ->
                VALIDATIONS.add(validation)
        );
    }

    @Override
    public void validate(Order order, OFSErrors errors) throws Exception {
        for (OrderCreateValidation validation : VALIDATIONS) {
            validation.validate(order, errors);
        }

        if(!errors.isEmpty()) {
            throw new BadRequestException(errors);
        }
    }

    @Override
    public void validate(ChangeSet changeSet, Order order, OFSErrors errors) throws Exception {
        for (OrderCreateValidation validation : VALIDATIONS) {
            validation.validate(changeSet, order, errors);
        }

        if(!errors.isEmpty()) {
            throw new BadRequestException(errors);
        }
    }
}
