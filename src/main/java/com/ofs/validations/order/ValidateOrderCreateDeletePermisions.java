package com.ofs.validations.order;

import com.ofs.model.Order;
import com.ofs.server.errors.UnauthorizedException;
import com.ofs.server.form.update.ChangeSet;
import com.ofs.server.model.OFSErrors;
import com.ofs.server.security.SecurityContext;
import com.ofs.server.security.Subject;
import com.ofs.validations.OrderCreateValidation;
import org.springframework.stereotype.Component;

@Component
public class ValidateOrderCreateDeletePermisions implements OrderCreateValidation {

    @Override
    public void validate(Order order, OFSErrors errors) throws Exception {
        Subject subject = SecurityContext.getSubject();

        if(subject.getRole().equalsIgnoreCase("CUSTOMER") || subject.getRole().equalsIgnoreCase("WAREHOUSE")) {
            throw new UnauthorizedException("OAuth", "OFSServer");
        }
    }

    @Override
    public void validate(ChangeSet changeSet, Order order, OFSErrors errors) throws Exception {
        validate(order, errors);
    }
}
