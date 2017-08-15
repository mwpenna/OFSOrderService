package com.ofs.validations.order;

import com.ofs.model.Order;
import com.ofs.server.errors.UnauthorizedException;
import com.ofs.server.form.update.ChangeSet;
import com.ofs.server.model.OFSErrors;
import com.ofs.server.security.SecurityContext;
import com.ofs.server.security.Subject;
import com.ofs.utils.StringUtils;
import com.ofs.validations.OrderGetValidation;
import org.springframework.stereotype.Component;

@Component
public class ValidateOrderAccountManagerRole implements OrderGetValidation {
    @Override
    public void validate(Order order, OFSErrors errors) throws Exception {
        Subject subject = SecurityContext.getSubject();

        if(subject.getRole().equals("ACCOUNT_MANAGER")) {
            if(!StringUtils.getIdFromURI(subject.getCompanyHref()).equals(order.getCompanyId())) {
                throw new UnauthorizedException("OAuth", "OFSServer");
            }
        }
    }

    @Override
    public void validate(ChangeSet changeSet, Order order, OFSErrors errors) throws Exception {

    }
}
