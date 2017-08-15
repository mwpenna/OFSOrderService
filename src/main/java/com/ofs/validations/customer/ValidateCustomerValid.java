package com.ofs.validations.customer;

import com.ofs.model.Order;
import com.ofs.model.userservice.User;
import com.ofs.server.form.update.ChangeSet;
import com.ofs.server.model.OFSErrors;
import com.ofs.server.security.SecurityContext;
import com.ofs.server.security.Subject;
import com.ofs.service.UserService;
import com.ofs.utils.StringUtils;
import com.ofs.validations.OrderCreateValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidateCustomerValid implements OrderCreateValidation {

    @Autowired
    private UserService userService;

    @Override
    public void validate(Order order, OFSErrors errors) throws Exception {
        Optional<User> userOptional = userService.getUserById(order.getCustomer().getId().toString());

        if(userOptional.isPresent()) {
            User user = userOptional.get();

            Subject subject = SecurityContext.getSubject();
            if(user.getCompany()!= null) {
                if(!user.getCompany().getId().toString().equals(StringUtils.getIdFromURI(subject.getCompanyHref()))) {
                    errors.rejectValue("order.customer.company.id", "User does not exists for company.");
                }
            }
            else {
                errors.rejectValue("order.customer.company.id", "User does not exists for company.");
            }
        }
        else {
            errors.rejectValue("order.customer.id","Customer with id does not exists.");
        }
    }

    @Override
    public void validate(ChangeSet changeSet, Order order, OFSErrors errors) throws Exception {
        validate(order, errors);
    }
}
