package com.ofs.validators;

import com.ofs.model.Order;
import com.ofs.server.errors.BadRequestException;
import com.ofs.server.form.update.ChangeSet;
import com.ofs.server.model.OFSErrors;
import com.ofs.validations.OrderGetValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderGetValidator implements Validator<Order> {

    private final List<OrderGetValidation> VALIDATIONS = new ArrayList<>();

    @Autowired
    public OrderGetValidator(List<OrderGetValidation> validations) {
        validations.forEach(validation ->
                VALIDATIONS.add(validation)
        );
    }

    @Override
    public void validate(Order order, OFSErrors errors) throws Exception {
        for (OrderGetValidation validation : VALIDATIONS) {
            validation.validate(order, errors);
        }

        if(!errors.isEmpty()) {
            throw new BadRequestException(errors);
        }
    }

    @Override
    public void validate(ChangeSet changeSet, Order order, OFSErrors errors) throws Exception {
        for (OrderGetValidation validation : VALIDATIONS) {
            validation.validate(changeSet, order, errors);
        }

        if(!errors.isEmpty()) {
            throw new BadRequestException(errors);
        }
    }
}
